package br.pcrn.deprov.interceptors;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.caelum.vraptor.view.Results;
import br.pcrn.deprov.anotacoes.Seguranca;
import br.pcrn.deprov.controller.LoginController;
import br.pcrn.deprov.dominio.Perfil;
import br.pcrn.deprov.dominio.UsuarioLogado;

import javax.inject.Inject;

@Intercepts(after = AutenticacaoInterceptor.class)
public class SegurancaInterceptor {

    private Result resultado;
    private UsuarioLogado usuarioLogado;

    @Inject
    public SegurancaInterceptor(Result resultado, UsuarioLogado usuarioLogado) {
        this.resultado = resultado;
        this.usuarioLogado = usuarioLogado;
    }

    @Deprecated SegurancaInterceptor(){}

    @Accepts
    public boolean verificarSegurança(ControllerMethod method){
        return !method.getController().getType().equals(LoginController.class);
    }

    private boolean verificarPermissao(ControllerMethod method){
        return method.getController().getType().getAnnotation(Seguranca.class) != null
                || method.containsAnnotation(Seguranca.class);
    }

    @AroundCall
    public void autoriza(SimpleInterceptorStack stack, ControllerMethod method) {
        if(usuarioLogado.isAdministrador()){
            resultado.include("administradorMaster", true);
            resultado.include("administradorDelegacia",true);
            resultado.include("administradorPlantao",true);

        }
        else if(usuarioLogado.isAdministradorDelegacia()){
            resultado.include("administradorDelegacia",true);
            resultado.include("administradorPlantao",true);
        }
        else if(usuarioLogado.isAdministradorPlantao()) {
            resultado.include("administradorPlantao",true);
        }
        acesso(method);
        stack.next();
    }

    /**
     * Verifica as permissões através da anotação @Seguranca
     * @param method
     * @return
     */
    public boolean acesso(ControllerMethod method){
        Seguranca anotacaoMethod = method.getMethod().getAnnotation(Seguranca.class);
        Seguranca anotacaoClasse = method.getController().getType().getAnnotation(Seguranca.class);

        if(possuiAnotacao(anotacaoMethod, anotacaoClasse)) {
            if(anotacaoMethod != null) {
                if(verificarAnotacoes(anotacaoMethod)){
                    return true;
                } else {
                    resultado.use(Results.http()).sendError(403, "Usuário não autorizado");
                }
            } else {
                if(anotacaoClasse != null) {
                    if(verificarAnotacoes(anotacaoClasse)){
                        return true;
                    } else {
                        resultado.use(Results.http()).sendError(403, "Usuário não autorizado");
                    }
                }
            }
        }

        return true;
    }

    public boolean verificarAnotacoes(Seguranca anotacao) {
        if (anotacao.perfil().equals(Perfil.ADMINISTRADOR_MASTER)) {
            if(usuarioLogado.isAdministrador()){
                return true;
            } else {
                return false;
            }
        }
        else if(anotacao.perfil().equals(Perfil.ADMINISTRADOR_DELEGACIA)) {
            if(usuarioLogado.isAdministradorDelegacia()){
                return true;
            } else {
                return false;
            }
        }
        else if(anotacao.perfil().equals(Perfil.ADMINISTRADOR_PLANTAO)) {
            if(usuarioLogado.isAdministradorPlantao()){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean acessoMethod(Seguranca anotacao){
        boolean permitido = anotacao.perfil().equals(usuarioLogado.getUsuario().getPerfil());
        return permitido;
    }

    public boolean possuiAnotacao(Seguranca anotacaoMethod, Seguranca anotacaoClasse) {
        return (anotacaoMethod != null || anotacaoClasse != null);
    }
    public boolean apenasMetodoAnotado(Seguranca anotacaoMethod, Seguranca anotacaoClasse) {
        return (anotacaoMethod != null && anotacaoClasse == null);
    }
}
