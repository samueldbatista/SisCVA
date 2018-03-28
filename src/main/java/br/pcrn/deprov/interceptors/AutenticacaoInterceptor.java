package br.pcrn.deprov.interceptors;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.pcrn.deprov.controller.LoginController;
import br.pcrn.deprov.dao.TarefaDao;
import br.pcrn.deprov.dominio.Tarefa;
import br.pcrn.deprov.dominio.UsuarioLogado;

import javax.inject.Inject;
import java.util.List;

@Intercepts
public class AutenticacaoInterceptor {
    private UsuarioLogado usuario;
    private Result resultado;
    @Inject
    private TarefaDao tarefaDao;


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
            List<Tarefa> tarefas = tarefaDao.buscarUltimasTarefas();
            resultado.include("ultimasTarefas",tarefas);
            resultado.include("totalTarefas",tarefas.size());
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
