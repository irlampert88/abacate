package com.univates.tcc.abacate.dominio.utilitarios;

import java.lang.annotation.Annotation;
import java.util.Collection;

import com.univates.tcc.abacate.dominio.agregadores.Foto;

public class IdentificadorDeAnotacoes {

	private IdentificadorDeAnotacoes() {
	}
	
	public static boolean possuiFoto(Collection<Annotation> annotations) {
		for (Annotation a : annotations) {
			if (a.annotationType().getCanonicalName().equals(Foto.class.getCanonicalName()))
				return true;
		}
		
		return false;
	}

}
