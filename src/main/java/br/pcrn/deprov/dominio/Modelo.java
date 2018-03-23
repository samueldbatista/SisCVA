package br.pcrn.deprov.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/** Esta Classe que possui os metodos de acesso getter e setters que representa o modelo do veiculo, 
 * e tamb�m possui o mapeamento relacional das tabelas via hibernate, da entidade Modelo.
*   
* @author silas
*
*/

@Entity
public class Modelo extends Entidade implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String modelo;

	@ManyToOne
	private Fabricante fabricante;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}

}