package com.univates.tcc.abacate.dominio.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.dominio.entidades.Terminacao;
import com.univates.tcc.abacate.dominio.repositorios.TerminacaoRepositorio;
import com.univates.tcc.abacate.dominio.servicos.TerminacaoServico;

@Service
public final class TerminacaoServicoImpl 
	extends ServicoDeCrudImpl<TerminacaoRepositorio, Terminacao, Integer>
		implements TerminacaoServico {

	@Autowired
	public TerminacaoServicoImpl(TerminacaoRepositorio repositorio) {
		super(repositorio);
	}
}
