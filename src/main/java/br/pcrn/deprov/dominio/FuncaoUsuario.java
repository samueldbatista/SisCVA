package br.pcrn.deprov.dominio;

import br.pcrn.deprov.conversor.ConvertivelOpcaoSelect;

public enum FuncaoUsuario implements ConvertivelOpcaoSelect {

    DELEGADO("Delegado"), ESCRIVAO("Escrivão"), APC("Agente de policia civil"),ESTAGIARIO("Estagiário");

    String chave;

    FuncaoUsuario(String chave) {
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
