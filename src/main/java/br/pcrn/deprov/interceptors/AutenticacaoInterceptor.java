package br.pcrn.deprov.interceptors;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.pcrn.deprov.controller.LoginController;
import br.pcrn.deprov.dominio.UsuarioLogado;

import javax.inject.Inject;

@Intercepts
public class AutenticacaoInterceptor {
    private UsuarioLogado usuario;
    private Result resultado;

    @Inject
    public AutenticacaoInterceptor(UsuarioLogado usuarioLogado, Result resultado) {
        this.usuario = usuarioLogado;
        this.resultado = resultado;
    }

    @Deprecated
    AutenticacaoInterceptor(){}

    @AroundCall
    public void autentica(SimpleInterceptorStack stack){
        if(usuario.isLogado()){
            inserirPermicoes(usuario);
            resultado.include("usuarioLogado", usuario);
            stack.next();
        } else {
            resultado.redirectTo(LoginController.class).form();
        }
    }

    @Accepts
    public boolean ehRestrito(ControllerMethod method){
        return !method.getController().getType().equals(LoginController.class);
    }

    private void inserirPermicoes(UsuarioLogado usuario) {

    }

}
