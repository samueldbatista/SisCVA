package br.pcrn.deprov.dominio;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LogMovimentacao extends Entidade{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_alteracao")
    private LocalDateTime dataAlteracao;

    private String informacao;

    public LogMovimentacao() {
    }

    public LogMovimentacao(LocalDateTime dataAlteracao, String informacao) {
        this.dataAlteracao = dataAlteracao;
        this.informacao = informacao;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public String getInformacao() {
        return informacao;
    }

    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }
}
