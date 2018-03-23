package br.pcrn.deprov.dao;

import br.pcrn.deprov.dominio.Local;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class LocalJpaDao extends EntidadeJpaDao<Local> implements LocalDao {


    @Deprecated
    protected LocalJpaDao(){
        this(null);
    }

    @Inject
    public LocalJpaDao(EntityManager entityManager) {
        super(entityManager, Local.class);
    }
}
