package br.pcrn.deprov.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.pcrn.deprov.anotacoes.Transacional;
import br.pcrn.deprov.dao.EntidadeDao;
import br.pcrn.deprov.dominio.Fabricante;

import javax.inject.Inject;

@Controller
public class FabricanteController extends ControladorDeprov<Fabricante> {

    @Deprecated
    protected FabricanteController() {
        this(null, null);
    }

    @Inject
    public FabricanteController(Result resultado, EntidadeDao<Fabricante> dao) {
        super(resultado, dao);
    }

    public void form() {
    }

    public void lista() {
        resultado.include("fabricantes",dao.listar());
    }

    public void editar() {

    }

    @Post
    @Transacional
    public void salvar(Fabricante fabricante) {
        dao.salvar(fabricante);
        this.resultado.redirectTo(this).lista();
    }

    @Transacional
    public void remover(Long id) {
        Fabricante fabricante = dao.buscarPorId(id);
        dao.remover(fabricante);
        resultado.redirectTo(this).lista();
    }
}
