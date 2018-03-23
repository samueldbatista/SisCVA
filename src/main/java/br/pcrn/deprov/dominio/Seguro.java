package br.pcrn.deprov.dominio;

import java.io.Serializable;

import javax.persistence.*;

/** Classe Seguro que possui os metodos de acesso getter e setters, 
 * e tamb�m o mapeamento relacional das tabelas via hibernate, da entidade Seguro do veiculo.
*   
* @author silas
*
*/

@Entity
public class Seguro extends Entidade implements Serializable, Cloneable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String seguro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSeguro() {
		return seguro;
	}

	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}

}
