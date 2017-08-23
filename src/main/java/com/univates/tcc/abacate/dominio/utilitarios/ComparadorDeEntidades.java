package com.univates.tcc.abacate.dominio.utilitarios;

import java.io.Serializable;

public final class ComparadorDeEntidades implements Serializable {

	private static final long serialVersionUID = 1L;

	private ComparadorDeEntidades() {
	}
	
	public static int comparar(Object some, Object other) {
		if (some == null && other == null) 
			return 0;
		
		if (some == null && other != null || 
				some != null && other == null)
			return -1;
		
		return Integer.valueOf(some.hashCode()).compareTo(Integer.valueOf(other.hashCode()));
	}
	
}
