package br.pcrn.deprov.dao;

import br.pcrn.deprov.dominio.Delegacia;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class DelegaciaJpaDao extends EntidadeJpaDao<Delegacia> implements DelegaciaDao {

    @Deprecated
    protected DelegaciaJpaDao(){
        this(null);
    }

    @Inject
    public DelegaciaJpaDao(EntityManager entityManager) {
        super(entityManager, Delegacia.class);
    }
}
