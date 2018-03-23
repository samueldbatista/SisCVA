package br.pcrn.deprov.dao;

import br.pcrn.deprov.dominio.Seguro;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class SeguroJpaDao extends EntidadeJpaDao<Seguro> implements SeguroDao {

    @Deprecated
    protected SeguroJpaDao(){
        this(null);
    }

    @Inject
    public SeguroJpaDao(EntityManager entityManager) {
        super(entityManager, Seguro.class);
    }
}
