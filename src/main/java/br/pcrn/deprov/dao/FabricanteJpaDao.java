package br.pcrn.deprov.dao;

import br.pcrn.deprov.dominio.Fabricante;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class FabricanteJpaDao extends EntidadeJpaDao<Fabricante> implements FabricanteDao {

    @Deprecated
    protected FabricanteJpaDao(){this(null);}

    @Inject
    public FabricanteJpaDao(EntityManager entityManager) {
        super(entityManager, Fabricante.class);
    }
}
