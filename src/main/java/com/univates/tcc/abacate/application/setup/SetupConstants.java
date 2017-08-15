package com.univates.tcc.abacate.application.setup;

public interface SetupConstants {

	interface DataSource { // Package
		public final String MAIN_DATASOURCE = "AbacateDS";
		public final String ENTITY_MANAGER = "entityManager";
		public final String ENTITY_MANAGER_FACTORY = "entityManagerFactory";
		public final String TRANSACTION_MANAGER = "transactionManager";
		
		interface Properties {
			public final String DDL_AUTO = "hibernate.hbm2ddl.auto";
			public final String DIALECT = "hibernate.dialect";
			public final String SHOW_SQL = "hibernate.show_sql";
			public final String FORMAT_SQL = "hibernate.format_sql";
		}
	}
	
	public interface Packages {
		public final String PREFIX = "com.univates.tcc.abacate.";
		public final String APPLICATION= PREFIX + "application";
		public final String DOMAIN = PREFIX + "domain";
		public final String INTEGRATION = PREFIX + "integration";
		public final String REPOSITORY = DOMAIN + ".repositories";
		public final String REPOSITORY_INTEGRATION = INTEGRATION + ".repositories.spring";
		public final String ENTITIES = DOMAIN + ".entities";
	}
	
	
}
