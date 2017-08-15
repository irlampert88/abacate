package com.univates.tcc.abacate.domain.helpers;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public final class HashCodeGenerator implements Serializable {

	private static final long serialVersionUID = 1L;

	private HashCodeGenerator() {
	}
	
	public static final <ANY> int generate(ANY object) {
		try {
			return calculateResult(object);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	private static int calculateResult(Object object) throws Exception {
		final int prime = 31;
		int result = 1;
		
		for (Field field : object.getClass().getDeclaredFields()) {
			
			if (canCalculate(field)) {
				field.setAccessible(true);
				
				Object fieldValue = field.get(object);
				
				result = prime * result + ((fieldValue == null) ? 0 : fieldValue.hashCode());
			}
		}
		
		return result;
	}

	private static boolean canCalculate(Field field) {
		return !Modifier.isStatic(field.getModifiers()) && Modifier.isPrivate(field.getModifiers());
	}
	
}
