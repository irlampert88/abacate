package com.univates.tcc.abacate.dominio.agregadores;

import java.io.Serializable;

public interface Identificado<ID extends Serializable> {

	public ID getId();
	public void setId(ID id);
}
