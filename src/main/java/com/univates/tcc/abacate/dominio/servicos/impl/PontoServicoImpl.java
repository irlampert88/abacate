package com.univates.tcc.abacate.dominio.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.dominio.entidades.Ponto;
import com.univates.tcc.abacate.dominio.repositorios.PontoRepositorio;
import com.univates.tcc.abacate.dominio.servicos.PontoServico;

@Service
public final class PontoServicoImpl 
	extends ServicoDeCrudImpl<PontoRepositorio, Ponto, Integer>
		implements PontoServico {

	@Autowired
	public PontoServicoImpl(PontoRepositorio repositorio) {
		super(repositorio);
	}
}
