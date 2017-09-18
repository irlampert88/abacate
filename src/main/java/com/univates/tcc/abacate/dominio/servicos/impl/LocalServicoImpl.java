package com.univates.tcc.abacate.dominio.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.dominio.entidades.Local;
import com.univates.tcc.abacate.dominio.repositorios.LocalRepositorio;
import com.univates.tcc.abacate.dominio.servicos.LocalServico;
import com.univates.tcc.abacate.integracao.repositorios.agregadores.ConsultasPeloExemplo;

@Service
public final class LocalServicoImpl 
	extends ServicoDeCrudImpl<LocalRepositorio, Local, Integer>
		implements LocalServico {

	@Autowired
	public LocalServicoImpl(LocalRepositorio repositorio, ConsultasPeloExemplo consultaPeloExemplo) {
		super(repositorio, consultaPeloExemplo);
	}
}
