package br.pcrn.deprov.dominio;

import java.io.Serializable;

import javax.persistence.*;

/** Classe Cor que possui os metodos de acesso getter e setters, 
 * e tamb�m o mapeamento relacional das tabelas via hibernate, da entidade Cor.
*   
* @author silas
*
*/

@Entity
public class Local extends Entidade implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String local;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}