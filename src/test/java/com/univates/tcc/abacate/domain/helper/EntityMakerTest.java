package com.univates.tcc.abacate.domain.helper;

import org.junit.Assert;
import org.junit.Test;

import com.univates.tcc.abacate.aggregates.mock.data.CreateFoo;
import com.univates.tcc.abacate.domain.entities.Foo;

public class EntityMakerTest {

	private final Long id = 10L;
	private final String nick = "Foo";
	private final Long document = 123L;
	
	@Test
	public void testACloneFromFoo() {
		Foo example = CreateFoo.from(id, nick, document);
		Foo cloneObject = (Foo) example.clone();
		
		Assert.assertEquals(example, cloneObject);
	}
	
	@Test
	public void testCloneByHashcodeFromFoo() {
		Foo example = CreateFoo.from(id, nick, document);
		Foo cloneObject = (Foo) example.clone();
		
		Assert.assertEquals(example.hashCode(), cloneObject.hashCode());
	}
	
}
