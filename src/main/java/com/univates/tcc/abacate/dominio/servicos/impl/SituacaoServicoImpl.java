package com.univates.tcc.abacate.dominio.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.dominio.entidades.Situacao;
import com.univates.tcc.abacate.dominio.repositorios.SituacaoRepositorio;
import com.univates.tcc.abacate.dominio.servicos.SituacaoServico;
import com.univates.tcc.abacate.integracao.repositorios.agregadores.ConsultasPeloExemplo;

@Service
public final class SituacaoServicoImpl 
	extends ServicoDeCrudImpl<SituacaoRepositorio, Situacao, Integer>
		implements SituacaoServico {

	@Autowired
	public SituacaoServicoImpl(SituacaoRepositorio repositorio, ConsultasPeloExemplo consultaPeloExemplo) {
		super(repositorio, consultaPeloExemplo);
	}
}
