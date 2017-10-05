package com.univates.tcc.abacate.dominio.fabricas;

import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;
import com.univates.tcc.abacate.dominio.entidades.Permissao;
import com.univates.tcc.abacate.dominio.utilitarios.NomeDaTabela;

public class FabricaDePermissao {

	private FabricaDePermissao() {
	}

	public static <CLASSE extends EntidadeAbstrata<?>> Permissao criarParaEntidade(Class<CLASSE> classeDaEntidade) {
		Permissao permissao = new Permissao();
		
		permissao.setAlterar(false);
		permissao.setConsultar(false);
		permissao.setDeletar(false);
		permissao.setInserir(false);
		permissao.setTabela(NomeDaTabela.daClasse(classeDaEntidade));
		
		return permissao;
	}
	
}
