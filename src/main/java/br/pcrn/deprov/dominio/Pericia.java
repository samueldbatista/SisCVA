package br.pcrn.deprov.dominio;

import java.io.Serializable;

import javax.persistence.*;

/** Esta Classe que possui os metodos de acesso getter e setters que representa uma Exame Veicular do veiculo, 
 * e tamb�m possui o mapeamento relacional das tabelas via hibernate, da entidade Pericia.
*   
* @author silas
*
*/

@Entity
public class Pericia extends Entidade implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String pericia;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getPericia() {
		return pericia;
	}

	public void setPericia(String pericia) {
		this.pericia = pericia;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}

}
