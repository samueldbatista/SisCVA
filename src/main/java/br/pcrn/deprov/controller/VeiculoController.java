package br.pcrn.deprov.controller;

import br.com.caelum.vraptor.*;
import br.com.caelum.vraptor.jasperreports.Report;
import br.com.caelum.vraptor.jasperreports.download.ReportDownload;
import br.com.caelum.vraptor.jasperreports.formats.ExportFormats;
import br.com.caelum.vraptor.observer.download.Download;
import br.com.caelum.vraptor.observer.download.FileDownload;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.caelum.vraptor.view.Results;
import br.pcrn.deprov.anotacoes.ControleDelegacia;
import br.pcrn.deprov.anotacoes.Seguranca;
import br.pcrn.deprov.anotacoes.Transacional;
import br.pcrn.deprov.dao.*;
import br.pcrn.deprov.dominio.*;
import br.pcrn.deprov.dominio.relatorios.EntidadeReport;
import br.pcrn.deprov.dominio.relatorios.RelatorioVeiculo;
import br.pcrn.deprov.negocio.Negocio;
import br.pcrn.deprov.util.GerenciadorEmail;
import br.pcrn.deprov.util.OpcaoSelect;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Created by samue on 17/12/2017.
 */
@Controller
public class VeiculoController extends ControladorDeprov<Veiculo> {

    private Negocio negocio;

    @Inject
    private ServletContext context;

    @Inject
    private ModeloDao modeloDao;

    @Inject
    private VeiculoDao veiculoDao;

    @Inject
    private FotoDao fotoDao;

    @Inject
    private HttpServletRequest request;

    @Inject
    private UsuarioLogado usuarioLogado;

    @Inject
    private DocumentoDao documentoDao;

    @Inject
    private LogMovimentacaoDao logMovimentacaoDao;

    @Deprecated
    public VeiculoController(){
        this(null, null,null);
    }

    @Inject
    public VeiculoController(Result resultado, EntidadeDao<Veiculo> dao, Negocio negocio) {
        super(resultado, dao);
        this.negocio = negocio;
    }

    @Seguranca(perfil = Perfil.ADMINISTRADOR_PLANTAO)
    public void form(){
        resultado.include("fabricantes",negocio.geraListaOpcoesFabricante());
        resultado.include("pericias",negocio.geraListaOpcoesPericia());
        resultado.include("cores",negocio.geraListaOpcoesCor());
        resultado.include("locais",negocio.geraListaOpcoesLocal());
        resultado.include("seguros",negocio.geraListaOpcoesSeguro());
        resultado.include("situacoes",negocio.geraListaOpcoesSituacoes());
        resultado.include("tipos",negocio.geraListaOpcoesTipo());
        resultado.include("delegacias", negocio.geraListaOpcoesDelegacia());
        resultado.include("idDelegacia", usuarioLogado.getUsuario().getDelegacia().getId());
    }

    public void lista(){
        resultado.include("delegacias", negocio.geraListaOpcoesDelegacia());
    }

    @Path("/veiculo/listagem")
    public void listaDelegacia() {
        List<Veiculo> veiculos = veiculoDao.buscarVeiculosPorDelegacia(usuarioLogado.getUsuario().getDelegacia().getId());
        resultado.include("veiculos",veiculos);
    }

    @Post
    @Transacional
    public void salvar(Veiculo veiculo) {
        dao.salvar(veiculo);
        LogMovimentacao logMovimentacao = new LogMovimentacao(LocalDateTime.now(),"O veiculo de placa "
                + veiculo.getPlacaOriginal()+" foi registrado/atualizado pelo usuário "+usuarioLogado.getUsuario().getNome()+"." +
                "\n Obs: "+ veiculo.getDadosOcorrencia().getObs());
        logMovimentacaoDao.salvar(logMovimentacao);
        GerenciadorEmail.enviarEmail("pedro.deprov@gmail.com","SisCVA - Cadastro/Atualização de veículo",logMovimentacao.getInformacao());
        resultado.redirectTo(VeiculoController.class).lista();
    }

    @ControleDelegacia
    @Seguranca(perfil = Perfil.ADMINISTRADOR_DELEGACIA)
    public void editar(Long id) {
        Veiculo veiculo = dao.buscarPorId(id);

        resultado.include("fabricantes",negocio.geraListaOpcoesFabricante());
        resultado.include("modelos",negocio.geraListaOpcoesModelo());
        resultado.include("pericias",negocio.geraListaOpcoesPericia());
        resultado.include("cores",negocio.geraListaOpcoesCor());
        resultado.include("locais",negocio.geraListaOpcoesLocal());
        resultado.include("seguros",negocio.geraListaOpcoesSeguro());
        resultado.include("situacoes",negocio.geraListaOpcoesSituacoes());
        resultado.include("tipos",negocio.geraListaOpcoesTipo());
        resultado.include("veiculo", veiculo);
        resultado.include("delegacias", negocio.geraListaOpcoesDelegacia());
        resultado.include("idDelegacia", usuarioLogado.getUsuario().getDelegacia().getId());
        resultado.of(this).form();
    }

    public void detalhes(Long id) {
        Veiculo veiculo = dao.buscarPorId(id);
        resultado.include("veiculo",veiculo);
    }

    @Get
    public void buscarMoleloPorFabricante (Long idFabricante) {
        List<Modelo> modelos = modeloDao.buscarPorFabricante(idFabricante);
        JsonArray jsonModelos =  new JsonArray();
        for(Modelo modelo : modelos) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id",modelo.getId());
            jsonObject.addProperty("modelo",modelo.getModelo());
            jsonModelos.add(jsonObject);
        }
        resultado.use(Results.json()).withoutRoot().from(jsonModelos).recursive().serialize();
    }

    @Seguranca(perfil = Perfil.ADMINISTRADOR_DELEGACIA)
    @Get
    @Path("/imprimirRelatorioVeiculo")
    public Download imprimirRelatorioVeiculo(Long id) {
        Veiculo veiculo = this.dao.buscarPorId(id);
        List<RelatorioVeiculo> relatorios = this.negocio.gerarRelatorioVeiculo(veiculo);
        Report report = new EntidadeReport<RelatorioVeiculo>(relatorios, "termoResponsabilidade.jasper", context);
        ReportDownload download = new ReportDownload(report, ExportFormats.pdf(), false);
        return download;

    }


    public void fotos(Long id) {
        Veiculo veiculo = dao.buscarPorId(id);
        resultado.include("veiculo",veiculo);
        resultado.include("fotos",veiculo.getFotos());
    }

    @Transacional
    @Path("/salvarFotos")
    @Post
    public void salvarFotos(Veiculo veiculo, UploadedFile foto) throws IOException{
        Arquivo arquivo = new Arquivo();
        Foto foto1 = new Foto();
        Veiculo veiculo1 = dao.buscarPorId(veiculo.getId());
        String path = context.getRealPath("/") + "resources/imagens/" + veiculo.getId();
        String urlFoto = "../resources/imagens/" + veiculo.getId()+"/" + foto.getFileName();
        foto1.setPath(urlFoto);
        foto1.setVeiculo(veiculo1);
        fotoDao.salvar(foto1);
        veiculo1.getFotos().add(foto1);
        File file = new File( path);
        file.mkdir();

        arquivo.upload(path,
                foto.getFileName(),foto.getFile());
//        resultado.include("imagem","resources/imagens/"+foto.getFileName());
        resultado.redirectTo(this).fotos(veiculo.getId());
    }

    @Transacional
    @Path("/salvarDocumento")
    @Post
    public void salvarDocumento(Veiculo veiculo, Documento informacao, UploadedFile documento) throws IOException{
        Arquivo arquivo = new Arquivo();
        Documento doc = new Documento();
        doc.setDescricao(informacao.getDescricao());
        doc.setTipo(documento.getContentType());
        doc.setData(LocalDateTime.now());
        doc.setNome(documento.getFileName());
        Veiculo veiculo1 = dao.buscarPorId(veiculo.getId());
        String path = context.getRealPath("/") + "resources/documentos/" + veiculo.getId();
        String urlDoc = "../resources/documentos/" + veiculo.getId()+"/" + documento.getFileName();
        doc.setPath(urlDoc);
        documentoDao.salvar(doc);
        veiculo1.getDocumentos().add(doc);
        File file = new File(path);
        file.mkdir();

        arquivo.upload(path,
                documento.getFileName(),documento.getFile());
        resultado.redirectTo(this).documentos(veiculo.getId());
    }


    @Get
    public void verificarChave(String chave) {
        Optional<Veiculo> veiculo = veiculoDao.buscarVeiculoPelaChave(chave);
        if(veiculo.isPresent()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("veiculo", veiculo.get().getModelo().getModelo());
            jsonObject.addProperty("placa", veiculo.get().getPlacaOriginal());
            resultado.use(Results.json()).withoutRoot().from(jsonObject).recursive().serialize();
        }
    }

    @Get
    public void verificarPlaca(String placa) {
        Optional<Veiculo> veiculo = veiculoDao.buscarVeiculoPelaPlaca(placa);
        if(veiculo.isPresent()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("veiculo", veiculo.get().getModelo().getModelo());
            jsonObject.addProperty("placa", veiculo.get().getPlacaOriginal());
            resultado.use(Results.json()).withoutRoot().from(jsonObject).recursive().serialize();
        }
    }

    @Get
    public void verificarPlacaOriginal(String placaOriginal) {
        Optional<Veiculo> veiculo = veiculoDao.buscarVeiculoPelaPlacaOriginal(placaOriginal);
        if(veiculo.isPresent()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("veiculo", veiculo.get().getModelo().getModelo());
            jsonObject.addProperty("placa", veiculo.get().getPlacaOriginal());
            resultado.use(Results.json()).withoutRoot().from(jsonObject).recursive().serialize();
        }
    }

    /**
     * @param id
     */
    @Get
    @Seguranca(perfil = Perfil.ADMINISTRADOR_PLANTAO)
    public void veiculosPorDelegacia(Long id) {
        List<Veiculo> veiculos = veiculoDao.buscarVeiculosPorDelegacia(id);
        JsonArray jsonArray = new JsonArray();
        for(Veiculo veiculo : veiculos) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id",veiculo.getId());
            jsonObject.addProperty("dossie",veiculo.getDadosOcorrencia().getDossie());
            jsonObject.addProperty("dataEntrada",negocio.retornarData(veiculo));
            jsonObject.addProperty("modelo",negocio.retornarModelo(veiculo));
            jsonObject.addProperty("fabricante",negocio.retornarFabricante(veiculo));
            jsonObject.addProperty("placa",veiculo.getPlaca());
            jsonObject.addProperty("placaOriginal",veiculo.getPlacaOriginal());
            jsonObject.addProperty("cor",negocio.retornarCor(veiculo));
            jsonObject.addProperty("seguro",negocio.retornarSeguro(veiculo));
            jsonObject.addProperty("localAtual",negocio.retornarLocal(veiculo));
            jsonObject.addProperty("exame",negocio.retornarPericia(veiculo));
            jsonObject.addProperty("situacao",negocio.retornarSituacao(veiculo));
            jsonArray.add(jsonObject);
        }
        resultado.use(Results.json()).withoutRoot().from(jsonArray).recursive().serialize();

    }

    public void documentos(Long id) {
        Veiculo veiculo = dao.buscarPorId(id);
        resultado.include("veiculo",veiculo);
    }


    @Transacional
    @Get
    @Path("/veiculo/removerDocumento/{id}")
    @Seguranca(perfil = Perfil.ADMINISTRADOR_MASTER)
    public void removerDocumento(Long id) {
        Documento documento =  documentoDao.buscarPorId(id);
        documentoDao.remover(documento);
        resultado.redirectTo(VeiculoController.class).lista();
    }

}
