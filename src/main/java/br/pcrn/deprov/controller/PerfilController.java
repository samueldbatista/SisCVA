package br.pcrn.deprov.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.pcrn.deprov.dominio.Usuario;
import br.pcrn.deprov.dominio.UsuarioLogado;

import javax.inject.Inject;

@Controller
public class PerfilController extends Controlador{

    @Inject
    private UsuarioLogado usuarioLogado;

    @Deprecated
    protected PerfilController() {
        this(null);
    }

    @Inject
    public PerfilController(Result resultado) {
        super(resultado);
    }

    public void perfil () {
        Usuario usuario  = usuarioLogado.getUsuario();
        resultado.include("usuario",usuario);
    }

}
