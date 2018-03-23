package br.pcrn.deprov.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.pcrn.deprov.anotacoes.Transacional;
import br.pcrn.deprov.dao.EntidadeDao;
import br.pcrn.deprov.dominio.Modelo;

import javax.inject.Inject;
@Controller
public class ModeloController extends ControladorDeprov<Modelo> {

    @Deprecated
    protected ModeloController() {
        this(null,null);
    }

    @Inject
    public ModeloController(Result resultado, EntidadeDao<Modelo> dao) {
        super(resultado, dao);
    }

    public void form() {
    }

    public void lista() {
        resultado.include("modelos",dao.listar());
    }

    public void editar() {

    }

    @Post
    @Transacional
    public void salvar(Modelo modelo) {
        dao.salvar(modelo);
        this.resultado.redirectTo(this).lista();
    }

    @Transacional
    public void remover(Long id) {
        Modelo modelo = dao.buscarPorId(id);
        dao.remover(modelo);
        resultado.redirectTo(this).lista();
    }

}
