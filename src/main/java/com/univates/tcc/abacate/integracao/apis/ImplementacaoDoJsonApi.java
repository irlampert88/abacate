package com.univates.tcc.abacate.integracao.apis;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.univates.tcc.abacate.aplicacao.apis.JsonApi;

@Component
public final class ImplementacaoDoJsonApi 
	implements JsonApi {

	private static final long serialVersionUID = 1L;
	
	private Gson gson;
	
	public ImplementacaoDoJsonApi() {
		gson = new Gson();
	}
	
	@Override
	public final <E> String paraJson(E object) {
		return gson.toJson(object);
	}

	@Override
	public final <E> E paraObjeto(Class<E> resultClass, String json) {
		return gson.fromJson(json, resultClass);
	}

}
