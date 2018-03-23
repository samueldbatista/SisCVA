package br.pcrn.deprov.dominio;

import java.io.Serializable;

import javax.persistence.*;

/** Classe Tipo que possui os metodos de acesso getter e setters, 
 * e tamb�m o mapeamento relacional das tabelas via hibernate, da entidade Tipo do veiculo.
*   
* @author silas
*
*/

@Entity
public class Tipo extends Entidade implements Serializable, Cloneable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String tipo;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}

}
