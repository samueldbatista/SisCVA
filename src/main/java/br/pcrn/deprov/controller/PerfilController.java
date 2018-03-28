package br.pcrn.deprov.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;

import javax.inject.Inject;

@Controller
public class PerfilController extends Controlador{

    @Deprecated
    protected PerfilController() {
        this(null);
    }

    @Inject
    public PerfilController(Result resultado) {
        super(resultado);
    }

    public void perfil () {

    }

}
