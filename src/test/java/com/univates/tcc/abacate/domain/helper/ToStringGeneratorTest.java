package com.univates.tcc.abacate.domain.helper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.univates.tcc.abacate.aggregates.mock.data.CreateFoo;
import com.univates.tcc.abacate.dominio.entidades.Foo;
import com.univates.tcc.abacate.dominio.utilitarios.GeradorDeToStringParaEntidades;

public class ToStringGeneratorTest {

	private final Long id = 10L;
	private final String nick = "Foo";
	private final Long document = 123L;
	
	private final String resultExpected = "Foo [id=" + id + ", nick=" + nick + ", document=" + document + "]";
	
	@Test
	public void testToStringFromGenerator() throws Exception {
		Foo example = CreateFoo.from(id, nick, document);
		final String toStringGenerated = GeradorDeToStringParaEntidades.gerar(example);
		assertEquals(resultExpected, toStringGenerated);
	}

	@Test
	public void testToStringFromAbstractEntity() throws Exception {
		Foo example = CreateFoo.from(id, nick, document);
		assertEquals(resultExpected, example.toString());
	}
	
}
