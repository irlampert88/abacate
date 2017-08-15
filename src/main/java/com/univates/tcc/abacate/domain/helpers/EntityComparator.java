package com.univates.tcc.abacate.domain.helpers;

import java.io.Serializable;

public final class EntityComparator implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityComparator() {
	}
	
	public static int compare(Object some, Object other) {
		if (some == null && other == null) 
			return 0;
		
		if (some == null && other != null || 
				some != null && other == null)
			return -1;
		
		return Integer.valueOf(some.hashCode()).compareTo(Integer.valueOf(other.hashCode()));
	}
	
}
