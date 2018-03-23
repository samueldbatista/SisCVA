package br.pcrn.deprov.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.pcrn.deprov.anotacoes.Transacional;
import br.pcrn.deprov.dao.EntidadeDao;
import br.pcrn.deprov.dominio.Situacao;

import javax.inject.Inject;

@Controller
public class SituacaoController extends ControladorDeprov<Situacao>{

    @Deprecated
    protected SituacaoController() {
        this(null,null);
    }
    @Inject
    public SituacaoController(Result resultado, EntidadeDao<Situacao> dao) {
        super(resultado, dao);
    }


    public void lista() {
        resultado.include("situacoes", dao.listar());
    }

    @Post
    @Transacional
    public void salvar(Situacao situacao) {
        this.dao.salvar(situacao);
        resultado.redirectTo(this).lista();
    }

    public void editar(Long id) {
        Situacao situacao = dao.buscarPorId(id);
        resultado.include("situacao",situacao);
        resultado.include("situacoes",dao.listar());
        resultado.of(this).lista();
    }

    @Transacional
    public void remover(Long id) {
        Situacao situacao = dao.buscarPorId(id);
        dao.remover(situacao);
        resultado.redirectTo(this).lista();
    }
}
