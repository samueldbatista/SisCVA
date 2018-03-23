package br.pcrn.deprov.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/** Classe Fabricante que possui os metodos de acesso getter e setters, 
 * e tamb�m o mapeamento relacional das tabelas via hibernate, da entidade Fabricante.
*   
* @author silas
*
*/

@Entity
public class Fabricante extends Entidade implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Modelo> modelo;

	private String fabricante;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
}
