package com.univates.tcc.abacate.dominio.excecoes;

public class AutenticacaoRequerida 
	extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AutenticacaoRequerida(String mensagemDeErro) {
		super(mensagemDeErro);
	}
}
