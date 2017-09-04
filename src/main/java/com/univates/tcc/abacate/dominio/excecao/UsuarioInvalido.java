package com.univates.tcc.abacate.dominio.excecao;

public final class UsuarioInvalido 
	extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UsuarioInvalido(String mensagemDeErro) {
		super(mensagemDeErro);
	}
	
}
