package com.univates.tcc.abacate.aggregates.mock.data;

import com.univates.tcc.abacate.domain.entities.Foo;

public class CreateFoo {

	private CreateFoo() {
	}
	
	public static Foo from(Long id, String nick, Long document) {
		Foo example = new Foo();
		example.setId(id);
		example.setNick(nick);
		example.setDocument(document);
		return example;
	}
	
}
