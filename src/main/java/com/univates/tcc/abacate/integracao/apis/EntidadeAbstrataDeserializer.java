package com.univates.tcc.abacate.integracao.apis;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;

@SuppressWarnings("all")
public class EntidadeAbstrataDeserializer implements JsonDeserializer<EntidadeAbstrata> {
    
	private final String nomeClasse;

	public EntidadeAbstrataDeserializer(String nomeClasse) {
		this.nomeClasse = nomeClasse;
	}

	@Override
    public EntidadeAbstrata deserialize(JsonElement json, Type member, JsonDeserializationContext context) {
    	try {
			return context.deserialize(json, Class.forName(nomeClasse));
		} catch (Exception e) {
			return null;
		}
    }

}
