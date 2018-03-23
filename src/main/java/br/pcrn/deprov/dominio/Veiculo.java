package br.pcrn.deprov.dominio;

import java.io.Serializable;

import java.util.List;

import javax.persistence.*;

/** Classe Veiculo que possui os metodos de acesso getter e setters, 
 * e tamb�m o mapeamento relacional das tabelas via hibernate, da entidade Veiculo.
*   
* @author silas
*
*/

@Entity
public class Veiculo extends Entidade implements Serializable, Cloneable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	private Modelo modelo;

	private String placa;
	private String placaOriginal;
	private String anoFabricacao;
	private String chassi;
	private String motor;
	private String condicao;
	private String proprietario;

	@ManyToOne(fetch = FetchType.EAGER)
	private Tipo tipo;

	@ManyToOne(fetch = FetchType.EAGER)
	private Cor cor;

	@ManyToOne(fetch = FetchType.EAGER)
	private Seguro seguro;

	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario usuario;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private DadosOcorrencia dadosOcorrencia;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Ocorrencia> ocorrencias;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Foto> fotos;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Tarefa> tarefas;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Documento> documentos;

	@ManyToOne
	private Delegacia delegacia;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getPlacaOriginal() {
		return placaOriginal;
	}

	public void setPlacaOriginal(String placaOriginal) {
		this.placaOriginal = placaOriginal;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public String getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	public String getCondicao() {
		return condicao;
	}

	public void setCondicao(String condicao) {
		this.condicao = condicao;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}

	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public DadosOcorrencia getDadosOcorrencia() {
		return dadosOcorrencia;
	}

	public void setDadosOcorrencia(DadosOcorrencia dadosOcorrencia) {
		this.dadosOcorrencia = dadosOcorrencia;
	}

	public Delegacia getDelegacia() {
		return delegacia;
	}

	public void setDelegacia(Delegacia delegacia) {
		this.delegacia = delegacia;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}

}