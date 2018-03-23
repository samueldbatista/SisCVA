package br.pcrn.deprov.dao;

import br.pcrn.deprov.dominio.Modelo;

import java.util.List;

public interface ModeloDao extends EntidadeDao<Modelo> {

    public List<Modelo> buscarPorFabricante(Long id);
}
