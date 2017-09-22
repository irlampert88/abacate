package com.univates.tcc.abacate.dominio.excecao;

public class SemPermissao 
	extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SemPermissao(String mensagemDeErro) {
		super(mensagemDeErro);
	}
}
