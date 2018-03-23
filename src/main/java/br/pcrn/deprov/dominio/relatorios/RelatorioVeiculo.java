package br.pcrn.deprov.dominio.relatorios;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RelatorioVeiculo extends Relatorio{

    private String chave;
    private String dossie;
    private String fabricante;
    private String modelo;
    private String cor;
    private String anoFabricacao;
    private String chassi;
    private String placa;
    private String placaOriginal;
    private String ip;
    private String processo;
    private String obs;
    private String motivo;
    private String dataEntrada;
    private String descricaoOcorrencia;

    public RelatorioVeiculo(String chave, String dossie, String fabricante, String modelo, String cor, String anoFabricacao, String chassi, String placa, String placaOriginal, String ip, String processo, String obs, String motivo) {

        this.chave = (chave != null) ? chave : "";
        this.dossie = (dossie != null) ? dossie : "";
        this.fabricante = (fabricante != null) ? fabricante : "";
        this.modelo = (modelo != null) ? modelo : "";
        this.cor = (cor != null) ? cor : "";
        this.anoFabricacao = (anoFabricacao != null) ? anoFabricacao : "";
        this.chassi = (chassi != null) ? chassi : "";
        this.placa =(placa != null) ? placa : "";
        this.placaOriginal = (placaOriginal != null) ? placaOriginal : "";
        this.ip = (ip != null) ? ip : "";
        this.processo = (processo != null) ? processo : "";
        this.obs = (obs != null) ? obs : "";
        this.motivo = (motivo != null) ? motivo : "";
    }


    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getDossie() {
        return dossie;
    }

    public void setDossie(String dossie) {
        this.dossie = dossie;
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

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDescricaoOcorrencia() {
        return descricaoOcorrencia;
    }

    public void setDescricaoOcorrencia(String descricaoOcorrencia) {
        this.descricaoOcorrencia = descricaoOcorrencia;
    }
}
