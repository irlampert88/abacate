package com.univates.tcc.abacate.dominio.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.dominio.entidades.Conector;
import com.univates.tcc.abacate.dominio.repositorios.ConectorRepositorio;
import com.univates.tcc.abacate.dominio.servicos.ConectorServico;

@Service
public final class ConectorServicoImpl 
	extends ServicoDeCrudImpl<ConectorRepositorio, Conector, Integer>
		implements ConectorServico {

	@Autowired
	public ConectorServicoImpl(ConectorRepositorio repositorio) {
		super(repositorio);
	}
}
