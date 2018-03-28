package br.pcrn.deprov.dao;

import br.pcrn.deprov.dominio.LogMovimentacao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;

public class LogMovimentacaoJpaDao extends EntidadeJpaDao<LogMovimentacao> implements LogMovimentacaoDao {

    @Deprecated
    protected LogMovimentacaoJpaDao(){this(null);}

    @Inject
    public LogMovimentacaoJpaDao(EntityManager entityManager) {
        super(entityManager, LogMovimentacao.class);
    }

    @Override
    public List<LogMovimentacao> retornarUltimasAlterações (){
        Query query = manager.createQuery("select l from LogMovimentacao l WHERE  l.dataAlteracao = :ultimas");
        query.setParameter("ultimas", LocalDateTime.now().minusDays(5));
        return query.getResultList();
    }
}
