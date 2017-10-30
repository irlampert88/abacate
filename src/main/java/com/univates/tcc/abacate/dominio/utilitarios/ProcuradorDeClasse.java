package com.univates.tcc.abacate.dominio.utilitarios;

import com.univates.tcc.abacate.aplicacao.configuracoes.ConstantesDeConfiguracao;

public class ProcuradorDeClasse {

	private ProcuradorDeClasse() {
	}
	
	public static Class classeDaEntidadePeloNome(String nomeDaClasse) {
		
		String pacoteEntidade = ConstantesDeConfiguracao.Pacotes.ENTIDADES;
		
		try {
			return Class.forName(pacoteEntidade + "." + nomeDaClasse);
		} catch (Exception e) {
			throw new IllegalArgumentException("Nome da Entidade inválido");
		}
	}
	
}
