package com.univates.tcc.abacate.dominio.entidades;

import java.io.Serializable;

import com.univates.tcc.abacate.dominio.utilitarios.ClonadorDeEntidades;
import com.univates.tcc.abacate.dominio.utilitarios.ComparadorDeEntidades;
import com.univates.tcc.abacate.dominio.utilitarios.GeradorDeEqualsParaEntidades;
import com.univates.tcc.abacate.dominio.utilitarios.GeradorDeHashcodeParaEntidades;
import com.univates.tcc.abacate.dominio.utilitarios.GeradorDeToStringParaEntidades;

public class ObjetoAbstrato 
	implements Serializable, Cloneable, Comparable<ObjetoAbstrato> {

	private static final long serialVersionUID = 1L;

	@Override
	public final int compareTo(ObjetoAbstrato otherEntity) {
		return ComparadorDeEntidades.comparar(this, otherEntity);
	}
	
	@Override
	public final Object clone() {
		return ClonadorDeEntidades.clonar(this);
	}
	
	@Override
	public final int hashCode() {
		return GeradorDeHashcodeParaEntidades.gerar(this);
	}
	
	@Override
	public final String toString() {
		return GeradorDeToStringParaEntidades.gerar(this);
	}
	
	@Override
	public final boolean equals(Object other) {
		return GeradorDeEqualsParaEntidades.verificaSeIgual(this, other);
	}
	
}
