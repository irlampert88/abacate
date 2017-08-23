package com.univates.tcc.abacate.integration.apis;

import org.junit.Test;

import com.univates.tcc.abacate.aggregates.mock.data.CreateFoo;
import com.univates.tcc.abacate.aplicacao.apis.JsonApi;
import com.univates.tcc.abacate.integracao.apis.ImplementacaoDoJsonApi;

public class JsonParserTest {

	private final JsonApi api = new ImplementacaoDoJsonApi();
	
	@Test
	public void testObjectToJson() {
		System.out.println(api.paraJson(CreateFoo.from(1L, "Ivan", 123456L)));
	}
	
	public static void main(String[] args) {
		new JsonParserTest().testObjectToJson();
	}
		
}
