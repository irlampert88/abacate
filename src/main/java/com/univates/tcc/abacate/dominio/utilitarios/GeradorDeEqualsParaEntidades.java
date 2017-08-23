package com.univates.tcc.abacate.dominio.utilitarios;

import java.io.Serializable;

public final class GeradorDeEqualsParaEntidades implements Serializable {

	private static final long serialVersionUID = 1L;

	private GeradorDeEqualsParaEntidades() {
	}
	
	public static boolean verificaSeIgual(Object object, Object other) {
		if (object == other)
			return true;
		
		if (object == null && other == null)
			return true;
		
		if ((object != null && other == null) || (object == null && other != null))
			return false;
		
		if (object.getClass() != other.getClass())
			return false;
		
		return object.hashCode() == other.hashCode();
	}
	
}
