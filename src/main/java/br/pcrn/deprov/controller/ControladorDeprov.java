package br.pcrn.deprov.controller;

import br.com.caelum.vraptor.Result;
import br.pcrn.deprov.dao.EntidadeDao;
import br.pcrn.deprov.dominio.Entidade;

public class ControladorDeprov<T extends Entidade> extends Controlador {

    protected EntidadeDao<T> dao;

    public ControladorDeprov(Result resultado, EntidadeDao<T> dao) {
        super(resultado);
        this.dao = dao;
    }


}
