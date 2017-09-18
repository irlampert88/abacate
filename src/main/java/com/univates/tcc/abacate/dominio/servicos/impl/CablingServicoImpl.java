package com.univates.tcc.abacate.dominio.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.dominio.entidades.Cabling;
import com.univates.tcc.abacate.dominio.repositorios.CablingRepositorio;
import com.univates.tcc.abacate.dominio.servicos.CablingServico;
import com.univates.tcc.abacate.integracao.repositorios.agregadores.ConsultasPeloExemplo;

@Service
public final class CablingServicoImpl 
	extends ServicoDeCrudImpl<CablingRepositorio, Cabling, Integer>
		implements CablingServico {

	@Autowired
	public CablingServicoImpl(CablingRepositorio repositorio, ConsultasPeloExemplo consultaPeloExemplo) {
		super(repositorio, consultaPeloExemplo);
	}
}
