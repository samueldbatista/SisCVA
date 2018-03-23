package br.pcrn.deprov.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.pcrn.deprov.anotacoes.Transacional;
import br.pcrn.deprov.dao.EntidadeDao;
import br.pcrn.deprov.dao.VeiculoDao;
import br.pcrn.deprov.dominio.Tarefa;
import br.pcrn.deprov.dominio.Veiculo;

import javax.inject.Inject;

@Controller
public class TarefaController extends ControladorDeprov<Tarefa>{

    @Inject
    private VeiculoDao veiculoDao;

    @Deprecated
    protected TarefaController(){
        this(null,null);
    }

    @Inject
    public TarefaController(Result resultado, EntidadeDao<Tarefa> dao) {
        super(resultado, dao);
    }
    public void lista (Long id) {
        Veiculo veiculo = veiculoDao.buscarPorId(id);
        resultado.include("veiculo", veiculo);
        resultado.include("tarefas", veiculo.getTarefas());
    }

    @Post
    @Transacional
    public void salvar (Tarefa tarefa) {
        Veiculo veiculo = veiculoDao.buscarPorId(tarefa.getVeiculo().getId());
        boolean existe = false;
        if(tarefa.getId() != null) {
            existe = true;
        }
        tarefa = dao.salvar(tarefa);
        if(!existe) {
            veiculo.getTarefas().add(tarefa);
        }

        resultado.redirectTo(this).lista(tarefa.getVeiculo().getId());
    }

    @Transacional
    public void remover (Long id) {
        Tarefa tarefa = dao.buscarPorId(id);
        dao.remover(tarefa);
        resultado.redirectTo(this).lista(tarefa.getVeiculo().getId());
    }

    public void editar (Long id) {
        Tarefa tarefa = dao.buscarPorId(id);
        Veiculo veiculo = veiculoDao.buscarPorId(tarefa.getVeiculo().getId());
        resultado.include("tarefa", tarefa);
        resultado.include("tarefas", tarefa.getVeiculo().getTarefas());
        resultado.include("veiculo", veiculo);
        resultado.of(this).lista(tarefa.getVeiculo().getId());
    }
}
