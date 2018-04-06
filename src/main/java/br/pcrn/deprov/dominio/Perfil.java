package br.pcrn.deprov.dominio;

import br.pcrn.deprov.conversor.ConvertivelOpcaoSelect;

public enum Perfil implements ConvertivelOpcaoSelect{

	ADMINISTRADOR_MASTER("Administrador master"),
	ADMINISTRADOR_DELEGACIA("Administrador de delegacia"),
	ADMINISTRADOR_PLANTAO("Administrador de plantão"),
	CONSULTA("Apenas para consultar");

	String chave;

	Perfil(String chave) {
		this.chave = chave;
	}


	@Override
	public String getChave() {
		return this.chave;
	}

	@Override
	public String getValor() { return this.toString();
	}



}
