package br.pcrn.deprov.controller;


import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.pcrn.deprov.anotacoes.ControleDelegacia;
import br.pcrn.deprov.anotacoes.Seguranca;
import br.pcrn.deprov.anotacoes.Transacional;
import br.pcrn.deprov.dao.UsuarioDao;
import br.pcrn.deprov.dominio.FuncaoUsuario;
import br.pcrn.deprov.dominio.Funcionalidade;
import br.pcrn.deprov.dominio.Perfil;
import br.pcrn.deprov.dominio.Usuario;
import br.pcrn.deprov.negocio.Negocio;
import br.pcrn.deprov.util.Criptografia;
import br.pcrn.deprov.util.OpcaoSelect;

import javax.inject.Inject;

@Seguranca(perfil = Perfil.ADMINISTRADOR_MASTER)
@Controller
public class UsuarioController extends Controlador {

    private UsuarioDao usuarioDao;
    private Negocio negocio;

    @Deprecated
    protected UsuarioController(){
        this(null,null, null);
    }

    @Inject
    public UsuarioController(Result resultado, UsuarioDao usuarioDao, Negocio negocio) {
        super(resultado);
        this.usuarioDao = usuarioDao;
        this.negocio = negocio;
    }

    public void form() {
        resultado.include("perfis", OpcaoSelect.toListaOpcoes(Perfil.values()));
        resultado.include("funcaoUsuario", OpcaoSelect.toListaOpcoes(FuncaoUsuario.values()));
        resultado.include("delegacias", negocio.geraListaOpcoesDelegacia());
    }

    public void lista() {
        resultado.include("usuarios", usuarioDao.listar());
    }

    @Post
    @Transacional
    public void salvar(Usuario usuario) {
        usuario.setSenha(Criptografia.criptografar(usuario.getSenha()));
        usuarioDao.salvar(usuario);
        resultado.redirectTo(UsuarioController.class).lista();
    }

    @Transacional
    public void remover(Long id) {
        Usuario usuario = usuarioDao.buscarPorId(id);
        usuarioDao.remover(usuario);
        resultado.redirectTo(this).lista();

    }

    public void editar(Long id) {
        Usuario usuario = usuarioDao.buscarPorId(id);
        resultado.include("perfis", OpcaoSelect.toListaOpcoes(Perfil.values()));
        resultado.include("funcaoUsuario", OpcaoSelect.toListaOpcoes(FuncaoUsuario.values()));
        resultado.include("delegacias", negocio.geraListaOpcoesDelegacia());
        resultado.include("usuario",usuario);
        resultado.of(this).form();
    }

    @Post
    @Transacional
    public void alterarSenha(Usuario usuario, String senhaAtual, String confirmaSenha) {
        Usuario usuarioBanco = usuarioDao.buscarPorId(usuario.getId());
        usuario.setSenha(Criptografia.criptografar(usuario.getSenha()));
        if(usuarioBanco.getSenha().equals(Criptografia.criptografar(senhaAtual))){
            if(usuario.getSenha().equals(Criptografia.criptografar(confirmaSenha))){
                usuarioBanco.setSenha(usuario.getSenha());
                usuarioDao.salvar(usuarioBanco);
                resultado.include("mensagem", new SimpleMessage("success","Conteúdo salvo com sucesso."));
            }
        } else {
            resultado.include("mensagem",new SimpleMessage("error","Dados inválidos"));

        }
        resultado.redirectTo(PerfilController.class).perfil();
    }
}
