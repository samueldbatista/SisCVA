package br.pcrn.deprov.dao;

import br.pcrn.deprov.dominio.Tarefa;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class TarefaJpaDao extends EntidadeJpaDao<Tarefa> implements TarefaDao {

    @Deprecated
    protected TarefaJpaDao() {
        this(null);
    }

    @Inject
    public TarefaJpaDao(EntityManager entityManager) {
        super(entityManager, Tarefa.class);
    }

    @Override
    public List<Tarefa> buscarUltimasTarefas() {
        LocalDate ultimosDias = LocalDate.now().minusDays(5);
        Query query = manager.createQuery("SELECT t FROM Tarefa t WHERE t.dataTarefa = :hoje");
        query.setParameter("hoje", LocalDate.now());
        query.setMaxResults(5);
        return query.getResultList();
    }
}
