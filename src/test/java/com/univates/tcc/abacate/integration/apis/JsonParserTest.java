package com.univates.tcc.abacate.integration.apis;

import org.junit.Test;

import com.univates.tcc.abacate.aggregates.mock.data.CreateFoo;
import com.univates.tcc.abacate.application.apis.JsonApi;

public class JsonParserTest {

	private final JsonApi api = new JsonApiParserImpl();
	
	@Test
	public void testObjectToJson() {
		System.out.println(api.toJson(CreateFoo.from(1L, "Ivan", 123456L)));
	}
	
	public static void main(String[] args) {
		new JsonParserTest().testObjectToJson();
	}
		
}
