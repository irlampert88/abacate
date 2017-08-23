package com.univates.tcc.abacate.dominio.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.dominio.entidades.Cabling;
import com.univates.tcc.abacate.dominio.repositorios.CablingRepositorio;
import com.univates.tcc.abacate.dominio.servicos.CablingServico;

@Service
public final class CablingServicoImpl 
	extends ServicoDeCrudImpl<CablingRepositorio, Cabling, Integer>
		implements CablingServico {

	@Autowired
	public CablingServicoImpl(CablingRepositorio repositorio) {
		super(repositorio);
	}
}
