package br.pcrn.deprov.dao;

import br.pcrn.deprov.dominio.LogMovimentacao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class LogMovimentacaoJpaDao extends EntidadeJpaDao<LogMovimentacao> implements LogMovimentacaoDao {

    @Deprecated
    protected LogMovimentacaoJpaDao(){this(null);}

    @Inject
    public LogMovimentacaoJpaDao(EntityManager entityManager) {
        super(entityManager, LogMovimentacao.class);
    }
}
