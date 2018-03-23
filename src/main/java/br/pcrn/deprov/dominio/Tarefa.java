package br.pcrn.deprov.dominio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Tarefa extends Entidade implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String descricaoTarefa;
	private Boolean ativada;
	private LocalDate dataTarefa;

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

	public String getDescricaoTarefa() {
		return descricaoTarefa;
	}

	public void setDescricaoTarefa(String descricaoTarefa) {
		this.descricaoTarefa = descricaoTarefa;
	}

	public Boolean getAtivada() {
		return ativada;
	}

	public void setAtivada(Boolean ativada) {
		this.ativada = ativada;
	}

	public LocalDate getDataTarefa() {
		return dataTarefa;
	}

	public void setDataTarefa(LocalDate dataTarefa) {
		this.dataTarefa = dataTarefa;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
}
