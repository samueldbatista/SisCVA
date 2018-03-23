package br.pcrn.deprov.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.pcrn.deprov.anotacoes.Transacional;
import br.pcrn.deprov.dao.EntidadeDao;
import br.pcrn.deprov.dominio.Delegacia;

import javax.inject.Inject;

@Controller
public class DelegaciaController extends ControladorDeprov<Delegacia> {

    @Deprecated
    protected DelegaciaController(){
        this(null,null);
    }

    @Inject
    public DelegaciaController(Result resultado, EntidadeDao<Delegacia> dao) {
        super(resultado, dao);
    }

    public void lista() {
        resultado.include("delegacias", dao.listar());
    }

    @Post
    @Transacional
    public void salvar(Delegacia delegacia) {
        this.dao.salvar(delegacia);
        resultado.redirectTo(this).lista();
    }

    public void editar(Long id) {
        Delegacia delegacia = dao.buscarPorId(id);
        resultado.include("delegacia",delegacia);
        resultado.include("delegacias",dao.listar());
        resultado.of(this).lista();
    }

    @Transacional
    public void remover(Long id) {
        Delegacia delgacia = dao.buscarPorId(id);
        dao.remover(delgacia);
        resultado.redirectTo(this).lista();
    }

}
