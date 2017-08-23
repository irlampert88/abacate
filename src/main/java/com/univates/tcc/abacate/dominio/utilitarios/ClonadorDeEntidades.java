package com.univates.tcc.abacate.dominio.utilitarios;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public final class ClonadorDeEntidades implements Serializable {

	private static final long serialVersionUID = 1L;

	private ClonadorDeEntidades() {
	}
	
	@SuppressWarnings("unchecked")
	public static final <ANY> ANY clonar(ANY cloneableObject) {
		try {
			Object newInstance = cloneableObject.getClass().newInstance();
			populateAtributesOfNewInstance(newInstance, cloneableObject);
			return (ANY) newInstance;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static void populateAtributesOfNewInstance(Object newInstance, Object cloneableObject) throws Exception {
		for (Field field : newInstance.getClass().getDeclaredFields()) {
			if (canPopulate(field)) {
				
				field.setAccessible(true);
				field.set(newInstance, field.get(cloneableObject));
			}
		}
	}
	
	private static boolean canPopulate(Field field) {
		return !Modifier.isStatic(field.getModifiers()) && Modifier.isPrivate(field.getModifiers());
	}
	
}
