package br.pcrn.deprov.dao;

import br.pcrn.deprov.dominio.Tarefa;

import java.util.List;

public interface TarefaDao extends EntidadeDao<Tarefa>{

    public List<Tarefa> buscarUltimasTarefas();
}
