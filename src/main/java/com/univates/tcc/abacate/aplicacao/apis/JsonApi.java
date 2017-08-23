package com.univates.tcc.abacate.aplicacao.apis;

import java.io.Serializable;

public interface JsonApi extends Serializable {

	public <E> String paraJson(E objeto);
	public <E> E paraObjeto(Class<E> classeDoObjeto, String json);
}
