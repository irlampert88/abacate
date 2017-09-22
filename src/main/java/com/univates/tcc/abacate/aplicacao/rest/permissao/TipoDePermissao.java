package com.univates.tcc.abacate.aplicacao.rest.permissao;

import com.univates.tcc.abacate.dominio.entidades.Permissao;
import com.univates.tcc.abacate.dominio.entidades.Usuario;

public enum TipoDePermissao {

	INSERIR {
		@Override
		void populaComTipoDePermissao(Permissao permissaoDeExemplo) {
			permissaoDeExemplo.setInserir(true);
		}
		
		@Override
		public boolean possuiPermissao(Permissao permissaoDaTabela) {
			return permissaoDaTabela.isInserir();
		}
	},
	ALTERAR {
		@Override
		void populaComTipoDePermissao(Permissao permissaoDeExemplo) {
			permissaoDeExemplo.setAlterar(true);
		}
		
		@Override
		public boolean possuiPermissao(Permissao permissaoDaTabela) {
			return permissaoDaTabela.isAlterar();
		}
	},
	DELETAR {
		@Override
		void populaComTipoDePermissao(Permissao permissaoDeExemplo) {
			permissaoDeExemplo.setDeletar(true);
		}
		
		@Override
		public boolean possuiPermissao(Permissao permissaoDaTabela) {
			return permissaoDaTabela.isDeletar();
		}
	},
	CONSULTAR {
		@Override
		void populaComTipoDePermissao(Permissao permissaoDeExemplo) {
			permissaoDeExemplo.setConsultar(true);
		}
		
		@Override
		public boolean possuiPermissao(Permissao permissaoDaTabela) {
			return permissaoDaTabela.isConsultar();
		}
	},
	;

	abstract void populaComTipoDePermissao(Permissao permissaoDeExemplo);
	public abstract boolean possuiPermissao(Permissao permissaoDaTabela);
	
	public Permissao montarPermissaoDeExemplo(Usuario usuario, String nomeDaTabela) {
		Permissao permissaoDeExemplo = new Permissao();
		permissaoDeExemplo.setUsuario(usuario);
		permissaoDeExemplo.setTabela(nomeDaTabela);
		populaComTipoDePermissao(permissaoDeExemplo);
		return permissaoDeExemplo;
	}

	
}
