package br.pcrn.deprov.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.pcrn.deprov.anotacoes.Transacional;
import br.pcrn.deprov.dao.EntidadeDao;
import br.pcrn.deprov.dominio.Local;

import javax.inject.Inject;

@Controller
public class LocalController extends ControladorDeprov<Local> {

    protected LocalController() {
        this(null,null);
    }

    @Inject
    public LocalController(Result resultado, EntidadeDao<Local> dao) {
        super(resultado, dao);
    }

    public void form() {

    }

    public void lista() {
        resultado.include("locais",dao.listar());
    }

    public void editar() {

    }

    @Post
    @Transacional
    public void salvar(Local local) {
        dao.salvar(local);
        this.resultado.redirectTo(this).lista();
    }

    @Transacional
    public void remover(Long id) {
        Local local = dao.buscarPorId(id);
        dao.remover(local);
        resultado.redirectTo(this).lista();
    }
}
