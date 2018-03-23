package br.pcrn.deprov.dao;

import br.pcrn.deprov.dominio.Tipo;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class TipoJpaDao extends EntidadeJpaDao<Tipo> implements TipoDao {

    @Deprecated
    protected TipoJpaDao() {
        this(null);
    }

    @Inject
    public TipoJpaDao(EntityManager entityManager) {
        super(entityManager, Tipo.class);
    }
}
