package br.pcrn.deprov.dao;

import br.pcrn.deprov.dominio.Ocorrencia;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class OcorrenciaJpaDao extends EntidadeJpaDao<Ocorrencia> implements OcorrenciaDao {

    @Deprecated
    protected OcorrenciaJpaDao() {
        this(null);
    }

    @Inject
    public OcorrenciaJpaDao(EntityManager entityManager) {
        super(entityManager, Ocorrencia.class);
    }
}
