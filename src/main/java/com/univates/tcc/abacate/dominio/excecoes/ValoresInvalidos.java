package com.univates.tcc.abacate.dominio.excecoes;

public final class ValoresInvalidos 
	extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ValoresInvalidos(String mensagemDeErro) {
		super(mensagemDeErro);
	}
	
}
