package com.univates.tcc.abacate.domain.aggregates;

import java.io.Serializable;

public interface Identifiable<ID extends Serializable> {

	public ID getId();
	public void setId(ID id);
}
