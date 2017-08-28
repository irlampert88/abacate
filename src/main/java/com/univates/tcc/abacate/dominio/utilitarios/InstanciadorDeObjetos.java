package com.univates.tcc.abacate.dominio.utilitarios;

import java.lang.reflect.Constructor;

public final class InstanciadorDeObjetos {

	private InstanciadorDeObjetos() {
	}
	
	public static <T> T criaInstancia(Class<T> classeDoObjeto) {
		try {
			return tentaInstanciarComConstrutorSemParametros(classeDoObjeto);
		} catch (Exception e) {
			return tentaInstanciarComConstrutorParametrizado(classeDoObjeto);
		}
	}

	private static <T> T tentaInstanciarComConstrutorParametrizado(Class<T> classeDoObjeto) {
		try {
			Constructor<?> construtor = classeDoObjeto.getConstructors()[0];
			
			Class<?>[] listaDoTipoDeParametros = construtor.getParameterTypes();
			
			Object[] parametros = new Object[listaDoTipoDeParametros.length];
			
			for (int i = 0; i < listaDoTipoDeParametros.length; i ++) {
				parametros[i] = null;
			}

			// Instancia pelo construtor com parâmetros. Passa lista de "null"
			return (T) construtor.newInstance(parametros);
		} catch (Exception erroAoInstanciar) {
			throw new IllegalArgumentException(erroAoInstanciar);
		}
	}

	private static <T> T tentaInstanciarComConstrutorSemParametros(Class<T> classeDoObjeto) throws Exception {
		return classeDoObjeto.newInstance();
	}
	
}
