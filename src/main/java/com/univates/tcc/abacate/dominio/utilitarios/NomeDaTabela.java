package com.univates.tcc.abacate.dominio.utilitarios;

import java.io.Serializable;

import javax.persistence.Table;

import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;

public final class NomeDaTabela 
	implements Serializable {

	private static final long serialVersionUID = 1L;

	private NomeDaTabela() {
	}
	
	public static <CLASSE extends EntidadeAbstrata<?>> String daClasse(Class<CLASSE> classeDaEntidade) {
		validaSeClassePossuiAnotacaoDeTabela(classeDaEntidade);
		
		return classeDaEntidade.getAnnotation(Table.class).name();
	}

	private static <CLASSE extends EntidadeAbstrata<?>> void validaSeClassePossuiAnotacaoDeTabela(Class<CLASSE> classeDaEntidade) {
		if (classeDaEntidade == null)
			throw new IllegalArgumentException("Não é possível identificar o nome da tabela de uma classe nula.");
		
		if (!classeDaEntidade.isAnnotationPresent(Table.class))
			throw new IllegalArgumentException("A classe " + classeDaEntidade.getSimpleName() + " não possui a anotação Table para identificar o nome da tabela.");
	}
	
}
