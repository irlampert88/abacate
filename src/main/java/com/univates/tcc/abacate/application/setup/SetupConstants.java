package com.univates.tcc.abacate.application.setup;

public interface SetupConstants {

	public final String MAIN_DATASOURCE_NAME = "AbacateDS";

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
