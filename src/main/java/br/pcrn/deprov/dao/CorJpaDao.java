package br.pcrn.deprov.dao;

import br.pcrn.deprov.dominio.Cor;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class CorJpaDao extends EntidadeJpaDao<Cor> implements CorDao {

    @Deprecated
    public CorJpaDao() {
        this(null);
    }

    @Inject
    public CorJpaDao(EntityManager entityManager) {
        super(entityManager, Cor.class);
    }

}
