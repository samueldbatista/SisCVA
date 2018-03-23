package br.pcrn.deprov.controller;

import br.com.caelum.vraptor.*;
import br.pcrn.deprov.dao.UsuarioDao;
import br.pcrn.deprov.dominio.Usuario;
import br.pcrn.deprov.dominio.UsuarioLogado;
import br.pcrn.deprov.dominio.Veiculo;

import javax.inject.Inject;
import java.util.Optional;

@Controller
public class LoginController extends Controlador{

    private UsuarioLogado usuarioLogado;
    private UsuarioDao usuarioDao;

    @Deprecated
    protected  LoginController(){
        this(null, null, null);
    }

    @Inject
    public LoginController(Result resultado, UsuarioLogado usuarioLogado, UsuarioDao usuarioDao) {
        super(resultado);
        this.usuarioLogado = usuarioLogado;
        this.usuarioDao = usuarioDao;
    }

    @Post("/login")
    public void login(Usuario usuario){
        Optional<Usuario> user = usuarioDao.buscarPorLogin(usuario.getLogin());
        if(user.isPresent()){
            usuarioLogado.setUsuario(user.get());
            resultado.redirectTo(VeiculoController.class).listaDelegacia();
        } else {
            resultado.redirectTo(this).form();
        }
    }

    @Path("/")
    public void form(){

    }

    @Get("/logout")
    public void logout(){
        this.usuarioLogado.desloga();
        this.resultado.redirectTo(this).form();
    }
}
