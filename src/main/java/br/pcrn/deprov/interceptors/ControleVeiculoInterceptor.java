package br.pcrn.deprov.interceptors;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.caelum.vraptor.view.Results;
import br.pcrn.deprov.anotacoes.ControleDelegacia;
import br.pcrn.deprov.anotacoes.Seguranca;
import br.pcrn.deprov.controller.LoginController;
import br.pcrn.deprov.controller.VeiculoController;
import br.pcrn.deprov.dao.VeiculoDao;
import br.pcrn.deprov.dominio.Perfil;
import br.pcrn.deprov.dominio.UsuarioLogado;
import br.pcrn.deprov.dominio.Veiculo;
import com.google.common.base.Strings;

import javax.inject.Inject;
import javax.naming.ldap.Control;
import javax.servlet.http.HttpServletRequest;

@Intercepts(after = SegurancaInterceptor.class)
public class ControleVeiculoInterceptor {
    private Result resultado;
    private UsuarioLogado usuarioLogado;
    private VeiculoDao veiculoDao;

    @Inject
    public ControleVeiculoInterceptor(Result resultado, UsuarioLogado usuarioLogado, VeiculoDao veiculoDao) {
        this.resultado = resultado;
        this.usuarioLogado = usuarioLogado;
        this.veiculoDao = veiculoDao;
    }

    @Deprecated ControleVeiculoInterceptor(){}

    @Accepts
    public boolean verificarSegurança(ControllerMethod method){
        return method.getMethod().getAnnotation(ControleDelegacia.class) != null;
    }

    @AroundCall
    public void autoriza(SimpleInterceptorStack stack, ControllerMethod method, HttpServletRequest httpServletRequest) {
        String id = httpServletRequest.getParameter("id");
        boolean acessar = true;
        if(!Strings.isNullOrEmpty(id)) {
            Veiculo veiculo = veiculoDao.buscarPorId(Long.valueOf(id));
            acessar = acesso(method, veiculo);
        }
        if(acessar) {
            stack.next();
        }
    }

    /**
     * Verifica as permissões através da anotação @Seguranca
     * @param method
     * @return
     */
    public boolean acesso(ControllerMethod method, Veiculo veiculo){
        boolean usuarioDelegacia = veiculo.getDelegacia().getId() == usuarioLogado.getUsuario().getDelegacia().getId();
        if(!(usuarioLogado.isAdministrador()  || usuarioDelegacia)) {
            resultado.use(Results.http()).sendError(403, "Usuário não autorizado");
            return false;
        }
        return true;
    }

}
