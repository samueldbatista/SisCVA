package br.pcrn.deprov.dao;

import br.pcrn.deprov.dominio.Tarefa;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class TarefaJpaDao extends EntidadeJpaDao<Tarefa> implements TarefaDao {

    @Deprecated
    protected TarefaJpaDao() {
        this(null);
    }

    @Inject
    public TarefaJpaDao(EntityManager entityManager) {
        super(entityManager, Tarefa.class);
    }
}
