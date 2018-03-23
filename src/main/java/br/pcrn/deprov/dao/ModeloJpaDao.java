package br.pcrn.deprov.dao;

import br.pcrn.deprov.dominio.Modelo;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ModeloJpaDao extends EntidadeJpaDao<Modelo> implements ModeloDao {

    @Deprecated
    protected ModeloJpaDao(){
        this(null);
    }

    @Inject
    public ModeloJpaDao(EntityManager entityManager) {
        super(entityManager, Modelo.class);
    }

    @Override
    public List<Modelo> buscarPorFabricante(Long id) {
        return manager.createQuery("SELECT m FROM Modelo m WHERE m.fabricante.id = :id").setParameter("id",id).getResultList();
    }
}
