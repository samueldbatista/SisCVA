package br.pcrn.deprov.dao;

import br.pcrn.deprov.dominio.DadosOcorrencia;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class DadosOcorrenciaJpaDao extends EntidadeJpaDao<DadosOcorrencia> implements DadosOcorrenciaDao{

    @Deprecated
    protected DadosOcorrenciaJpaDao() {
        this(null);
    }

    @Inject
    public DadosOcorrenciaJpaDao(EntityManager entityManager) {
        super(entityManager, DadosOcorrencia.class);
    }
}
