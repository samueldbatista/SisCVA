package br.pcrn.deprov.dominio.relatorios;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RelatorioGeral extends Relatorio {

    private String dossie;
    private String data;
    private String placaVeiculo;
    private String placaOriginal;
    private String fabricante;
    private String modelo;
    private String cor;
    private String seguro;
    private String localAtual;
    private String exame;
    private String situacao;
    private String chassi;
    private String processo;
    private Integer totalRegistro;
    private String itensProdurado;

    public RelatorioGeral() {
    }

    public RelatorioGeral(String dossie, String data, String placaVeiculo, String placaOriginal, String fabricante,
                          String modelo, String cor, String seguro, String localAtual, String exame, String situacao,
                          String chassi, String processo, Integer totalRegistro) {
        this.dossie = (dossie != null) ? dossie : "";
        this.data = (data != null) ? data : "";
        this.placaVeiculo = (placaVeiculo != null) ? placaVeiculo : "";
        this.placaOriginal = (placaOriginal != null) ? placaOriginal : "";
        this.fabricante = (fabricante != null) ? fabricante : "";
        this.modelo = (modelo != null) ? modelo : "";
        this.cor = (cor != null) ? cor : "";
        this.seguro = (seguro != null) ? seguro : "";
        this.localAtual = (localAtual != null) ? localAtual : "";
        this.exame = (exame != null) ? exame : "";
        this.situacao = (situacao != null) ? situacao : "";
        this.chassi = (chassi != null) ? chassi : "";
        this.processo = (processo != null) ? processo : "";
        this.totalRegistro = totalRegistro;
    }

    public String getDossie() {
        return dossie;
    }

    public void setDossie(String dossie) {
        this.dossie = dossie;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getPlacaOriginal() {
        return placaOriginal;
    }

    public void setPlacaOriginal(String placaOriginal) {
        this.placaOriginal = placaOriginal;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public String getLocalAtual() {
        return localAtual;
    }

    public void setLocalAtual(String localAtual) {
        this.localAtual = localAtual;
    }

    public String getExame() {
        return exame;
    }

    public void setExame(String exame) {
        this.exame = exame;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    public Integer getTotalRegistro() {
        return totalRegistro;
    }

    public void setTotalRegistro(Integer totalRegistro) {
        this.totalRegistro = totalRegistro;
    }

    public String getItensProdurado() {
        return itensProdurado;
    }

    public void setItensProdurado(String itensProdurado) {
        this.itensProdurado = itensProdurado;
    }
}
