package br.pcrn.deprov.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.pcrn.deprov.anotacoes.Transacional;
import br.pcrn.deprov.dao.EntidadeDao;
import br.pcrn.deprov.dominio.Cor;

import javax.inject.Inject;
import java.util.stream.Collectors;

@Controller
public class CorController extends ControladorDeprov<Cor> {

    @Deprecated
    protected CorController(){
        this(null,null);
    }

    @Inject
    public CorController(Result resultado, EntidadeDao<Cor> dao) {
        super(resultado, dao);
    }

    public void form() {

    }

    public void lista() {
        this.resultado.include("cores",dao.todos().stream().collect(Collectors.toList()));
    }

    @Transacional
    @Post
    public void salvar(Cor cor) {
        this.dao.salvar(cor);
        resultado.redirectTo(this).lista();
    }

    public void editar(Long id) {
        Cor cor = dao.buscarPorId(id);
        resultado.of(this).lista();
    }

    @Transacional
    public void remover(Long id) {
        Cor cor = dao.buscarPorId(id);
        dao.remover(cor);
        resultado.redirectTo(this).lista();
    }
}
