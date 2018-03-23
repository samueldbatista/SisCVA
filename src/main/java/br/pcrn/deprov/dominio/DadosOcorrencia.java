package br.pcrn.deprov.dominio;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by samue on 17/12/2017.
 */
@Entity
public class DadosOcorrencia extends Entidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String dossie;

    @Column(columnDefinition = "text")
    private String Obs;

    private String numeroOcorrencia;
    private String ip;
    private String processo;

    private String motivoApreensao;

    @ManyToOne(fetch = FetchType.EAGER)
    private Situacao situacao;

    @ManyToOne(fetch = FetchType.EAGER)
    private Local local;

    @ManyToOne(fetch = FetchType.EAGER)
    private Pericia pericia;

    private String chave;

    @Column(columnDefinition = "text")
    private String comentario;

    private LocalDate dataEntrada;

    @OneToOne(mappedBy = "dadosOcorrencia")
    private Veiculo veiculo;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getDossie() {
        return dossie;
    }

    public void setDossie(String dossie) {
        this.dossie = dossie;
    }

    public String getObs() {
        return Obs;
    }

    public void setObs(String obs) {
        Obs = obs;
    }

    public String getNumeroOcorrencia() {
        return numeroOcorrencia;
    }

    public void setNumeroOcorrencia(String numeroOcorrencia) {
        this.numeroOcorrencia = numeroOcorrencia;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Pericia getPericia() {
        return pericia;
    }

    public void setPericia(Pericia pericia) {
        this.pericia = pericia;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getMotivoApreensao() {
        return motivoApreensao;
    }

    public void setMotivoApreensao(String motivoApreensao) {
        this.motivoApreensao = motivoApreensao;
    }


}
