package com.univates.tcc.abacate.dominio.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.dominio.entidades.TipoRack;
import com.univates.tcc.abacate.dominio.repositorios.TipoRackRepositorio;
import com.univates.tcc.abacate.dominio.servicos.TipoRackServico;
import com.univates.tcc.abacate.integracao.repositorios.agregadores.ConsultasPeloExemplo;

@Service
public final class TipoRackServicoImpl 
	extends ServicoDeCrudImpl<TipoRackRepositorio, TipoRack, Integer>
		implements TipoRackServico {

	@Autowired
	public TipoRackServicoImpl(TipoRackRepositorio repositorio, ConsultasPeloExemplo consultaPeloExemplo) {
		super(repositorio, consultaPeloExemplo);
	}
}
