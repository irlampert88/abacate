package com.univates.tcc.abacate.aplicacao.configuracoes;

public interface ConstantesDeConfiguracao {

	interface BancoDeDados { // Package
		public final String DATASOURCE = "AbacateDS";
		public final String ENTITY_MANAGER = "entityManager";
		public final String ENTITY_MANAGER_FACTORY = "entityManagerFactory";
		public final String TRANSACTION_MANAGER = "transactionManager";
		
		interface Propriedades {
			public final String DDL_AUTO = "hibernate.hbm2ddl.auto";
			public final String DIALECT = "hibernate.dialect";
			public final String SHOW_SQL = "hibernate.show_sql";
			public final String FORMAT_SQL = "hibernate.format_sql";
		}
	}
	
	public interface Pacotes {
		public final String PREFIXO = "com.univates.tcc.abacate.";
		public final String APLICACAO = PREFIXO + "aplicacao";
		public final String DOMINIO = PREFIXO + "dominio";
		public final String INTEGRACAO = PREFIXO + "integracao";
		public final String REPOSITORIO = DOMINIO + ".repositorios";
		public final String REPOSITORIO_INTEGRADO = INTEGRACAO + ".repositorios.spring";
		public final String ENTIDADES = DOMINIO + ".entidades";
	}
	
	public interface Autenticacao {
		public final String TOKEN = "Authorization"; 
	}

	public interface Sessao {
		public final String USUARIO = "UsuarioLogado";
	}
	
}
