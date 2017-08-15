package com.univates.tcc.abacate.domain.helpers;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public final class CloneEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private CloneEntity() {
	}
	
	@SuppressWarnings("unchecked")
	public static final <ANY> ANY makeClone(ANY cloneableObject) {
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
