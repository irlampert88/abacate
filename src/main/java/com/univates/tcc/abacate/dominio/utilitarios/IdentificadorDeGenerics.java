package com.univates.tcc.abacate.dominio.utilitarios;

import java.lang.reflect.ParameterizedType;

public final class IdentificadorDeGenerics {

	public static final Integer PRIMEIRO_GENERIC = 0;
	public static final Integer SEGUNDO_GENERIC = 1;
	public static final Integer TERCEIRO_GENERIC = 2;
	
	private IdentificadorDeGenerics() {
	}
	
	public static Class<?> identificaClasseDeUmGeneric(Class<?> classeComGenerics, int posicaoDoGeneric) {
		ParameterizedType genericSuperclass = null;
		if (classeComGenerics.getGenericSuperclass() instanceof ParameterizedType) {
			genericSuperclass = (ParameterizedType) classeComGenerics.getGenericSuperclass();
		} else if (classeComGenerics.getSuperclass().getGenericSuperclass() instanceof ParameterizedType) {
			genericSuperclass = (ParameterizedType) classeComGenerics.getSuperclass().getGenericSuperclass();
		}

		lancarErroCasoNaoIdentificado(genericSuperclass);
		
		return (Class<?>) genericSuperclass.getActualTypeArguments()[posicaoDoGeneric];
	}

	private static void lancarErroCasoNaoIdentificado(ParameterizedType genericSuperclass) {
		if (genericSuperclass == null) {
			throw new RuntimeException("Nãoo foi possível inferir o tipo genérico.");
		}
	}
	
}
