package com.univates.tcc.abacate.application.apis;

import java.io.Serializable;

public interface JsonApi extends Serializable {

	public <E> String toJson(E object);
	public <E> E toObject(Class<E> resultClass, String json);
}
