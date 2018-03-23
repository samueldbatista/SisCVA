package br.pcrn.deprov.controller;

import br.com.caelum.vraptor.*;
import br.com.caelum.vraptor.jasperreports.Report;
import br.com.caelum.vraptor.jasperreports.download.ReportDownload;
import br.com.caelum.vraptor.jasperreports.formats.ExportFormats;
import br.com.caelum.vraptor.observer.download.Download;
import br.pcrn.deprov.anotacoes.Seguranca;
import br.pcrn.deprov.dao.VeiculoDao;
import br.pcrn.deprov.dominio.Perfil;
import br.pcrn.deprov.dominio.Veiculo;
import br.pcrn.deprov.dominio.relatorios.EntidadeReport;
import br.pcrn.deprov.dominio.relatorios.RelatorioGeral;
import br.pcrn.deprov.negocio.Negocio;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import java.util.List;
import java.util.stream.Collectors;

@Seguranca(perfil = Perfil.ADMINISTRADOR_DELEGACIA)
@Controller
public class RelatorioController extends Controlador{

    @Inject
    private ServletContext context;

    private VeiculoDao veiculoDao;
    private Negocio negocio;

    @Deprecated
    protected RelatorioController(){
        this(null, null,null);
    }

    @Inject
    public RelatorioController(Result resultado, VeiculoDao veiculoDao, Negocio negocio) {
        super(resultado);
        this.veiculoDao = veiculoDao;
        this.negocio = negocio;
    }

    @Seguranca(perfil = Perfil.ADMINISTRADOR_DELEGACIA)
    public void relatorios() {
        resultado.include("fabricantes",negocio.geraListaOpcoesFabricante());
        resultado.include("modelos",negocio.geraListaOpcoesModelo());
        resultado.include("seguros",negocio.geraListaOpcoesSeguro());
        resultado.include("situacoes",negocio.geraListaOpcoesSituacoes());
        resultado.include("locais",negocio.geraListaOpcoesLocal());
        resultado.include("cores",negocio.geraListaOpcoesCor());
        resultado.include("tipos",negocio.geraListaOpcoesTipo());
        resultado.include("pericias",negocio.geraListaOpcoesPericia());
    }

    @Seguranca(perfil = Perfil.ADMINISTRADOR_DELEGACIA)
    @Path("/imprimirRelatorios")
    public void imprimirRelatorios(){

    }

    @Post
    @Path("/imprimirFiltrado")
    public Download imprimirRelatorioVeiculo(RelatorioGeral relatorioGeral) {
        Report report = null;
        ReportDownload download = null;

        List<Veiculo> veiculos = this.veiculoDao.buscarParaRelatorioGeral(relatorioGeral);
        if(veiculos.size() > 0 ){
            List<RelatorioGeral> relatorios = this.negocio.gerarRelatorioFiltrado(veiculos);
            report = new EntidadeReport<RelatorioGeral>(relatorios, "RelatorioGeral.jasper", context);
            download = new ReportDownload(report, ExportFormats.pdf(), false);
        } else {
            report = new EntidadeReport<RelatorioGeral>(null, "resultadoVazio.jasper", context);
            download = new ReportDownload(report, ExportFormats.pdf(), false);
        }

        return download;

    }
}
