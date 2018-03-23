package br.pcrn.deprov.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.pcrn.deprov.anotacoes.Transacional;
import br.pcrn.deprov.dao.EntidadeDao;
import br.pcrn.deprov.dominio.Tipo;

import javax.inject.Inject;
import java.util.stream.Collectors;

@Controller
public class TipoController extends ControladorDeprov<Tipo> {

    @Deprecated
    protected TipoController(){
        this(null,null);
    }

    @Inject
    public TipoController(Result resultado, EntidadeDao<Tipo> dao) {
        super(resultado, dao);
    }

    public void form() {

    }

    public void lista() {
        resultado.include("tipos", dao.todos().stream().collect(Collectors.toList()));
    }

    public void editar() {

    }

    @Post
    @Transacional
    public void salvar(Tipo tipo) {
            dao.salvar(tipo);
            resultado.redirectTo(this).lista();
    }

    @Transacional
    public void remover(Long id) {
        Tipo tipo = dao.buscarPorId(id);
        dao.remover(tipo);
        resultado.redirectTo(this).lista();
    }
}
