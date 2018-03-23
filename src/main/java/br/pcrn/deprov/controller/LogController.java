package br.pcrn.deprov.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.pcrn.deprov.dao.EntidadeDao;
import br.pcrn.deprov.dominio.LogMovimentacao;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

@Controller
public class LogController extends ControladorDeprov<LogMovimentacao> {

    @Deprecated
    protected LogController(){
        this(null,null);
    }

    @Inject
    public LogController(Result resultado, EntidadeDao<LogMovimentacao> dao) {
        super(resultado, dao);
    }

    public void lista() {
        List<LogMovimentacao> logs = dao.listar();
        Collections.sort(logs, (LogMovimentacao p2, LogMovimentacao p1) -> p1.getId().compareTo(p2.getId()));

        resultado.include("logs",logs);
    }

}
