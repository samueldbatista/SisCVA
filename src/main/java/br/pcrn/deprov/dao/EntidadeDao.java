package br.pcrn.deprov.dao;

import br.pcrn.deprov.dominio.Entidade;

import java.util.Collection;
import java.util.List;

public interface EntidadeDao<T extends Entidade> {

    T buscarPorId(Long id);
    T salvar(T entidade);
    void remover(T entidade);
    List<T> listar();
    Collection<T> todos();
}