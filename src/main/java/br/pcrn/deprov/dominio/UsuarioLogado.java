package br.pcrn.deprov.dominio;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class UsuarioLogado implements Serializable{

    private Usuario usuario;
    private String nomeUsuario;

    public void loga(Usuario usuario){
        this.usuario = usuario;
    }

    public boolean isLogado() {
        return this.usuario != null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isAdministrador(){
        if(usuario.getPerfil().equals(Perfil.ADMINISTRADOR_MASTER)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isAdministradorDelegacia(){
        if(usuario.getPerfil().equals(Perfil.ADMINISTRADOR_MASTER) || usuario.getPerfil().equals(Perfil.ADMINISTRADOR_DELEGACIA)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAdministradorPlantao(){
        if(usuario.getPerfil().equals(Perfil.ADMINISTRADOR_MASTER) || usuario.getPerfil().equals(Perfil.ADMINISTRADOR_DELEGACIA)
                || usuario.getPerfil().equals(Perfil.ADMINISTRADOR_PLANTAO)) {
            return true;
        } else {
            return false;
        }
    }

    public void desloga(){
        this.usuario = null;
//        destruir();
    }
}
