package com.univates.tcc.abacate.dominio.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.dominio.entidades.Foo;
import com.univates.tcc.abacate.dominio.repositorios.FooRepositorio;
import com.univates.tcc.abacate.dominio.servicos.FooService;
import com.univates.tcc.abacate.integracao.repositorios.agregadores.ConsultasPeloExemplo;

@Service
public final class FooServiceImpl 
	extends ServicoDeCrudImpl<FooRepositorio, Foo, Long>
		implements FooService {

	@Autowired
	public FooServiceImpl(FooRepositorio repositorio, ConsultasPeloExemplo consultaPeloExemplo) {
		super(repositorio, consultaPeloExemplo);
	}
}
