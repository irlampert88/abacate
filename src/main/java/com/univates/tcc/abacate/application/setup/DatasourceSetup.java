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
@EnableJpaRepositories(entityManagerFactoryRef = SetupConstants.DataSource.ENTITY_MANAGER_FACTORY,
					   transactionManagerRef = SetupConstants.DataSource.TRANSACTION_MANAGER, 
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

	@Bean(name = SetupConstants.DataSource.ENTITY_MANAGER)
	public EntityManager entityManager() {
		return entityManagerFactory().createEntityManager();
	}

	@Primary
	@Bean(name = SetupConstants.DataSource.ENTITY_MANAGER_FACTORY)
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource);
		emf.setJpaVendorAdapter(jpaVendorAdapter);
		emf.setPackagesToScan(new String[] { SetupConstants.Packages.ENTITIES });
		emf.setPersistenceUnitName(SetupConstants.DataSource.MAIN_DATASOURCE);
		emf.setJpaProperties(additionalProperties());
		emf.afterPropertiesSet();
		return emf.getObject();
	}

	private Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty(SetupConstants.DataSource.Properties.DDL_AUTO, enviroment.getProperty(SetupConstants.DataSource.Properties.DDL_AUTO));
		properties.setProperty(SetupConstants.DataSource.Properties.DIALECT, enviroment.getProperty(SetupConstants.DataSource.Properties.DIALECT));
		properties.setProperty(SetupConstants.DataSource.Properties.SHOW_SQL, enviroment.getProperty(SetupConstants.DataSource.Properties.SHOW_SQL));
		properties.setProperty(SetupConstants.DataSource.Properties.FORMAT_SQL, enviroment.getProperty(SetupConstants.DataSource.Properties.FORMAT_SQL));
		return properties;
	}

	@Bean(name = SetupConstants.DataSource.TRANSACTION_MANAGER)
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager tm = new JpaTransactionManager();
		tm.setRollbackOnCommitFailure(true);
		tm.setEntityManagerFactory(entityManagerFactory());
		return tm;
	}

}
