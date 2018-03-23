package br.pcrn.deprov.dao;

import br.pcrn.deprov.dominio.Usuario;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Optional;

public class UsuarioJpaDao extends EntidadeJpaDao<Usuario> implements UsuarioDao {

    @Deprecated
    protected UsuarioJpaDao() {
        this(null);
    }

    @Inject
    public UsuarioJpaDao(EntityManager entityManager) {
        super(entityManager, Usuario.class);
    }

    @Override
    public Optional<Usuario> buscarPorLogin(String login) {
        Query query = manager.createQuery("SELECT u FROM Usuario u WHERE u.login = :login").setParameter("login",login).setMaxResults(1);
        return query.getResultList().stream().findFirst();
    }
}
