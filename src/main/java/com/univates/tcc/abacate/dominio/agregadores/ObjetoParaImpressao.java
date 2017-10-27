package com.univates.tcc.abacate.dominio.agregadores;

import java.io.Serializable;
import java.util.Collection;

import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;
import com.univates.tcc.abacate.dominio.entidades.ObjetoAbstrato;

public class ObjetoParaImpressao
	extends ObjetoAbstrato
		implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntidadeAbstrata entidadeDeExemplo;
	private Collection<String> titulos;
	private Collection<String> atributos;

	public EntidadeAbstrata getEntidadeDeExemplo() {
		return entidadeDeExemplo;
	}

	public void setEntidadeDeExemplo(EntidadeAbstrata entidadeDeExemplo) {
		this.entidadeDeExemplo = entidadeDeExemplo;
	}

	public Collection<String> getAtributos() {
		return atributos;
	}

	public void setAtributos(Collection<String> atributos) {
		this.atributos = atributos;
	}
	
	public Collection<String> getTitulos() {
		return titulos;
	}
	
	public void setTitulos(Collection<String> titulos) {
		this.titulos = titulos;
	}

}
