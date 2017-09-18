package com.univates.tcc.abacate.dominio.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.dominio.entidades.Terminacao;
import com.univates.tcc.abacate.dominio.repositorios.TerminacaoRepositorio;
import com.univates.tcc.abacate.dominio.servicos.TerminacaoServico;
import com.univates.tcc.abacate.integracao.repositorios.agregadores.ConsultasPeloExemplo;

@Service
public final class TerminacaoServicoImpl 
	extends ServicoDeCrudImpl<TerminacaoRepositorio, Terminacao, Integer>
		implements TerminacaoServico {

	@Autowired
	public TerminacaoServicoImpl(TerminacaoRepositorio repositorio, ConsultasPeloExemplo consultaPeloExemplo) {
		super(repositorio, consultaPeloExemplo);
	}
}
