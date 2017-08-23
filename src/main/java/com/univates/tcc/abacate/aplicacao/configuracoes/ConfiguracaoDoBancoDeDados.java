package com.univates.tcc.abacate.aplicacao.configuracoes;

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
@EnableJpaRepositories(entityManagerFactoryRef = ConstantesDeConfiguracao.BancoDeDados.ENTITY_MANAGER_FACTORY,
					   transactionManagerRef = ConstantesDeConfiguracao.BancoDeDados.TRANSACTION_MANAGER, 
					   basePackages = {
							ConstantesDeConfiguracao.Pacotes.REPOSITORIO, 
							ConstantesDeConfiguracao.Pacotes.REPOSITORIO_INTEGRADO })
public class ConfiguracaoDoBancoDeDados implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private JpaVendorAdapter jpaVendorAdapter;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private Environment enviroment;

	@Bean(name = ConstantesDeConfiguracao.BancoDeDados.ENTITY_MANAGER)
	public EntityManager entityManager() {
		return entityManagerFactory().createEntityManager();
	}

	@Primary
	@Bean(name = ConstantesDeConfiguracao.BancoDeDados.ENTITY_MANAGER_FACTORY)
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource);
		emf.setJpaVendorAdapter(jpaVendorAdapter);
		emf.setPackagesToScan(new String[] { ConstantesDeConfiguracao.Pacotes.ENTIDADES });
		emf.setPersistenceUnitName(ConstantesDeConfiguracao.BancoDeDados.DATASOURCE);
		emf.setJpaProperties(additionalProperties());
		emf.afterPropertiesSet();
		return emf.getObject();
	}

	private Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty(ConstantesDeConfiguracao.BancoDeDados.Propriedades.DDL_AUTO, enviroment.getProperty(ConstantesDeConfiguracao.BancoDeDados.Propriedades.DDL_AUTO));
		properties.setProperty(ConstantesDeConfiguracao.BancoDeDados.Propriedades.DIALECT, enviroment.getProperty(ConstantesDeConfiguracao.BancoDeDados.Propriedades.DIALECT));
		properties.setProperty(ConstantesDeConfiguracao.BancoDeDados.Propriedades.SHOW_SQL, enviroment.getProperty(ConstantesDeConfiguracao.BancoDeDados.Propriedades.SHOW_SQL));
		properties.setProperty(ConstantesDeConfiguracao.BancoDeDados.Propriedades.FORMAT_SQL, enviroment.getProperty(ConstantesDeConfiguracao.BancoDeDados.Propriedades.FORMAT_SQL));
		return properties;
	}

	@Bean(name = ConstantesDeConfiguracao.BancoDeDados.TRANSACTION_MANAGER)
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager tm = new JpaTransactionManager();
		tm.setRollbackOnCommitFailure(true);
		tm.setEntityManagerFactory(entityManagerFactory());
		return tm;
	}

}
