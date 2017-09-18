package com.univates.tcc.abacate.dominio.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.dominio.entidades.Rack;
import com.univates.tcc.abacate.dominio.repositorios.RackRepositorio;
import com.univates.tcc.abacate.dominio.servicos.RackServico;
import com.univates.tcc.abacate.integracao.repositorios.agregadores.ConsultasPeloExemplo;

@Service
public final class RackServicoImpl 
	extends ServicoDeCrudImpl<RackRepositorio, Rack, Integer>
		implements RackServico {

	@Autowired
	public RackServicoImpl(RackRepositorio repositorio, ConsultasPeloExemplo consultaPeloExemplo) {
		super(repositorio, consultaPeloExemplo);
	}
}
