package com.univates.tcc.abacate.dominio.utilitarios;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public final class GeradorDeToStringParaEntidades implements Serializable {

	private static final long serialVersionUID = 1L;

	private GeradorDeToStringParaEntidades() {
	}
	
	public static final <ANY> String gerar(ANY object) {
		try {
			return object.getClass().getSimpleName() + joinAllFields(object);
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro não esperado durante geração do 'toString'";
		}
	}

	private static String joinAllFields(Object entity) throws Exception {
		final StringBuilder fields = new StringBuilder(" [");
		
		for (Field field : entity.getClass().getDeclaredFields()) {
			
			if (canJoin(field)) {
				field.setAccessible(true);
				fields.append(field.getName() + "=" + field.get(entity) + ", ");
			}
		}
		
		return fields.append("]").toString().replace(", ]", "]");
	}

	private static boolean canJoin(Field field) {
		return !Modifier.isStatic(field.getModifiers()) && Modifier.isPrivate(field.getModifiers());
	}
	
}
