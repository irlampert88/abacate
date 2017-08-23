package com.univates.tcc.abacate.aplicacao.inicio;

import java.io.Serializable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.univates.tcc.abacate.aplicacao.configuracoes.ConstantesDeConfiguracao;

@EnableAutoConfiguration
@ComponentScan(basePackages= {
		ConstantesDeConfiguracao.Pacotes.APLICACAO,
		ConstantesDeConfiguracao.Pacotes.DOMINIO,
		ConstantesDeConfiguracao.Pacotes.INTEGRACAO}, 
    lazyInit=true)
@EnableJpaRepositories
@SpringBootApplication
public class Inicializador implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
        SpringApplication.run(Inicializador.class, args);
    }
    
}