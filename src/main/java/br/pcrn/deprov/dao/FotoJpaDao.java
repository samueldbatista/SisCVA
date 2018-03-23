package br.pcrn.deprov.dao;

import br.pcrn.deprov.dominio.Foto;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class FotoJpaDao extends EntidadeJpaDao<Foto> implements FotoDao {

    @Deprecated
    protected FotoJpaDao() {
        this(null);
    }

    @Inject
    public FotoJpaDao(EntityManager entityManager) {
        super(entityManager, Foto.class);
    }
}
