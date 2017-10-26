package com.univates.tcc.abacate.dominio.agregadores;

import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;

public class ObjetoParaImpressao {

	private EntidadeAbstrata<?> entidadeDeExemplo;
	private Iterable<String> atributos;

	public EntidadeAbstrata<?> getEntidadeDeExemplo() {
		return entidadeDeExemplo;
	}

	public void setEntidadeDeExemplo(EntidadeAbstrata<?> entidadeDeExemplo) {
		this.entidadeDeExemplo = entidadeDeExemplo;
	}

	public Iterable<String> getAtributos() {
		return atributos;
	}

	public void setAtributos(Iterable<String> atributos) {
		this.atributos = atributos;
	}

}
