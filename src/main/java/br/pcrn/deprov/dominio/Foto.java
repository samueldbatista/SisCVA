package br.pcrn.deprov.dominio;

import java.io.Serializable;

import javax.persistence.*;

/** Classe Foto que possui os metodos de acesso getter e setters, 
 * e tamb�m o mapeamento relacional das tabelas via hibernate, da entidade Foto.
*   
* @author silas
*
*/

@Entity
public class Foto extends Entidade implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String path;

	@ManyToOne
	private Veiculo veiculo;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
}