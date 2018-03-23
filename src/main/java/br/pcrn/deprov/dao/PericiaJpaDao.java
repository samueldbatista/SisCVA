package br.pcrn.deprov.dao;

import br.pcrn.deprov.dominio.Pericia;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class PericiaJpaDao extends EntidadeJpaDao<Pericia> implements PericiaDao {

    @Deprecated
    protected PericiaJpaDao(){
        this(null);
    }

    @Inject
    public PericiaJpaDao(EntityManager entityManager) {
        super(entityManager, Pericia.class);
    }
}
