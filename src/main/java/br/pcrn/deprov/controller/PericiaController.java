package br.pcrn.deprov.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.pcrn.deprov.anotacoes.Transacional;
import br.pcrn.deprov.dao.EntidadeDao;
import br.pcrn.deprov.dominio.Pericia;

import javax.inject.Inject;

@Controller
public class PericiaController extends ControladorDeprov<Pericia>{

    @Deprecated
    protected PericiaController(){
        this(null,null);
    }

    @Inject
    public PericiaController(Result resultado, EntidadeDao<Pericia> dao) {
        super(resultado, dao);
    }

    public void form() {

    }

    public void lista() {
        resultado.include("pericias", dao.listar());
    }

    public void editar() {

    }

    @Post
    @Transacional
    public void salvar(Pericia pericia) {
        dao.salvar(pericia);
        this.resultado.redirectTo(this).lista();
    }

    @Transacional
    public void remover(Long id) {
        Pericia pericia = dao.buscarPorId(id);
        dao.remover(pericia);
        resultado.redirectTo(this).lista();
    }
}
