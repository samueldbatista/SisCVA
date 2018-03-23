package br.pcrn.deprov.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.pcrn.deprov.anotacoes.Transacional;
import br.pcrn.deprov.dao.EntidadeDao;
import br.pcrn.deprov.dominio.Seguro;
import org.apache.lucene.search.Collector;

import javax.inject.Inject;
import java.util.stream.Collectors;

@Controller
public class SeguroController extends ControladorDeprov<Seguro>{

    @Deprecated
    protected SeguroController() {
        this(null,null);
    }

    @Inject
    public SeguroController(Result resultado, EntidadeDao<Seguro> dao) {
        super(resultado, dao);
    }

    public void form() {

    }

    public void lista() {
        this.resultado.include("seguros",dao.todos().stream().collect(Collectors.toList()));
    }

    public void editar() {

    }

    @Post
    @Transacional
    public void salvar(Seguro seguro) {
        dao.salvar(seguro);
        this.resultado.redirectTo(this).lista();
    }

    @Transacional
    public void remover(Long id) {
        Seguro seguro = dao.buscarPorId(id);
        dao.remover(seguro);
        resultado.redirectTo(this).lista();
    }
}
