package br.pcrn.deprov.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.pcrn.deprov.anotacoes.Transacional;
import br.pcrn.deprov.dao.EntidadeDao;
import br.pcrn.deprov.dao.VeiculoDao;
import br.pcrn.deprov.dominio.Ocorrencia;
import br.pcrn.deprov.dominio.Tarefa;
import br.pcrn.deprov.dominio.Veiculo;

import javax.inject.Inject;

@Controller
public class OcorrenciaController extends ControladorDeprov<Ocorrencia> {

    @Inject
    private VeiculoDao veiculoDao;

    @Deprecated
    protected OcorrenciaController(){
        this(null,null);
    }

    @Inject
    public OcorrenciaController(Result resultado, EntidadeDao<Ocorrencia> dao) {
        super(resultado, dao);
    }

    public void lista (Long id) {
        Veiculo veiculo = veiculoDao.buscarPorId(id);
        resultado.include("veiculo", veiculo);
        resultado.include("ocorrencias", veiculo.getOcorrencias());
    }

    @Post
    @Transacional
    public void salvar (Ocorrencia ocorrencia) {
        Veiculo veiculo = veiculoDao.buscarPorId(ocorrencia.getVeiculo().getId());
        if(ocorrencia.getId() == null) {
            veiculo.getOcorrencias().add(ocorrencia);
        }
        ocorrencia = dao.salvar(ocorrencia);
        resultado.redirectTo(this).lista(ocorrencia.getVeiculo().getId());
    }

    @Transacional
    public void remover (Long id) {
        Ocorrencia ocorrencia = dao.buscarPorId(id);
        dao.remover(ocorrencia);
        resultado.redirectTo(this).lista(ocorrencia.getVeiculo().getId());
    }

    public void editar (Long id) {
        Ocorrencia ocorrencia = dao.buscarPorId(id);
        Veiculo veiculo = veiculoDao.buscarPorId(ocorrencia.getVeiculo().getId());
        resultado.include("ocorrencia", ocorrencia);
        resultado.include("ocorrencias", ocorrencia.getVeiculo().getOcorrencias());
        resultado.include("veiculo", veiculo);
        resultado.of(this).lista(ocorrencia.getVeiculo().getId());
    }

}
