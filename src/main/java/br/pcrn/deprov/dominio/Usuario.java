package br.pcrn.deprov.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/** Esta Classe que possui os metodos de acesso getter e setters que representa um usuario do sistema, 
 * e tamb�m possui o mapeamento relacional das tabelas via hibernate, da entidade Usuario.
*   
* @author silasx
*
*/

@Entity
public class Usuario extends Entidade implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String login;
	private String senha;

	@Enumerated(EnumType.STRING)
	private Perfil perfil;

	@Enumerated(EnumType.STRING)
	private FuncaoUsuario funcaoUsuario;

	@ManyToOne
	private Delegacia delegacia;
//	@ElementCollection(fetch = FetchType.EAGER)
//	@CollectionTable(name = "USUARIO_FUNCIONALIDADE",
//			joinColumns = @JoinColumn(name = "FUNCIONALIDADE_CD_IDENTIFICADOR"))
//	@Enumerated(EnumType.STRING)
//	List<Funcionalidade> funcionalidades;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public FuncaoUsuario getFuncaoUsuario() {
		return funcaoUsuario;
	}

	public void setFuncaoUsuario(FuncaoUsuario funcaoUsuario) {
		this.funcaoUsuario = funcaoUsuario;
	}

	public Delegacia getDelegacia() {
		return delegacia;
	}

	public void setDelegacia(Delegacia delegacia) {
		this.delegacia = delegacia;
	}
}