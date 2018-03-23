package br.pcrn.deprov.dominio;

import br.pcrn.deprov.conversor.ConvertivelOpcaoSelect;

import java.util.ArrayList;
import java.util.List;

public enum Funcionalidade implements ConvertivelOpcaoSelect {
    ADMINISTRAR_MASTER("Administrar master"),
    ADMINISTRAR_DP("Administrador de DP"),
    ADMINISTRAR_PLANTAO("Administrador de Plantão"),
    CONSULTAR("Usuário para consultas");

    String chave;

    Funcionalidade(String chave) {
        this.chave = chave;
    }


    @Override
    public String getChave() {
        return this.chave;
    }

    @Override
    public String getValor() {
        return this.toString();
    }

}
