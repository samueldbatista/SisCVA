package br.pcrn.deprov.dao;

import br.pcrn.deprov.dominio.Situacao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class SituacaoJpaDao extends EntidadeJpaDao<Situacao> implements SituacaoDao {

    @Deprecated
    protected SituacaoJpaDao() {
        this(null);
    }

    @Inject
    public SituacaoJpaDao(EntityManager entityManager) {
        super(entityManager, Situacao.class);
    }
}
