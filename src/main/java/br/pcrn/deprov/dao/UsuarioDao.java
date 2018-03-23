package br.pcrn.deprov.dao;

import br.pcrn.deprov.dominio.Usuario;

import java.util.Optional;

public interface UsuarioDao extends EntidadeDao<Usuario> {
    Optional<Usuario> buscarPorLogin(String login);
}
