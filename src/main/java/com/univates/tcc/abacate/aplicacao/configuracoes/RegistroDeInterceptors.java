package com.univates.tcc.abacate.aplicacao.configuracoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.univates.tcc.abacate.aplicacao.rest.interceptador.InterceptadorDeChamadasRest;

@Configuration
public class RegistroDeInterceptors extends WebMvcConfigurerAdapter {

	@Autowired
	private InterceptadorDeChamadasRest interceptadorDeChamadasRest;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptadorDeChamadasRest);
	}

}
