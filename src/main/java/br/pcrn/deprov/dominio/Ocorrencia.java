package br.pcrn.deprov.dominio;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


import javax.persistence.*;

/** Esta Classe que possui os metodos de acesso getter e setters que representa as ocorrencias de umn determinado veiculo, 
 * e tamb�m possui o mapeamento relacional das tabelas via hibernate, da entidade Ocorrencia.
*   
* @author silas
*
*/

@Entity
public class Ocorrencia extends Entidade implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String ocorrencia;
	private LocalDate data;

	@ManyToOne(fetch = FetchType.EAGER)
	private Veiculo veiculo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(String ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
}