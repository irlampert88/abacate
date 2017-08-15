package com.univates.tcc.abacate.application.setup;

import java.io.Serializable;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableAutoConfiguration
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory",
					   transactionManagerRef = "transactionManager", 
					   basePackages = {
							SetupConstants.Packages.REPOSITORY, 
							SetupConstants.Packages.REPOSITORY_INTEGRATION })
public class DatasourceSetup implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private JpaVendorAdapter jpaVendorAdapter;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private Environment enviroment;

	@Bean(name = "entityManager")
	public EntityManager entityManager() {
		return entityManagerFactory().createEntityManager();
	}

	@Primary
	@Bean(name = "entityManagerFactory")
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource);
		emf.setJpaVendorAdapter(jpaVendorAdapter);
		emf.setPackagesToScan(new String[] { SetupConstants.Packages.ENTITIES });
		emf.setPersistenceUnitName(SetupConstants.MAIN_DATASOURCE_NAME);
		emf.setJpaProperties(additionalProperties());
		emf.afterPropertiesSet();
		return emf.getObject();
	}

	private Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", enviroment.getProperty("hibernate.hbm2ddl.auto"));
		properties.setProperty("hibernate.dialect", enviroment.getProperty("hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", enviroment.getProperty("hibernate.show_sql"));
		properties.setProperty("hibernate.format_sql", enviroment.getProperty("hibernate.format_sql"));
		return properties;
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager tm = new JpaTransactionManager();
		tm.setRollbackOnCommitFailure(true);
		tm.setEntityManagerFactory(entityManagerFactory());
		return tm;
	}

}
