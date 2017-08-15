package com.univates.tcc.abacate.integration.apis;

import com.google.gson.Gson;
import com.univates.tcc.abacate.application.apis.JsonApi;

public final class JsonApiParserImpl 
	implements JsonApi {

	private static final long serialVersionUID = 1L;
	
	private Gson gson;
	
	public JsonApiParserImpl() {
		gson = new Gson();
	}
	
	@Override
	public final <E> String toJson(E object) {
		return gson.toJson(object);
	}

	@Override
	public final <E> E toObject(Class<E> resultClass, String json) {
		return gson.fromJson(json, resultClass);
	}

}
