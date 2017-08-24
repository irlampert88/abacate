package com.univates.tcc.abacate.dominio.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.dominio.entidades.Situacao;
import com.univates.tcc.abacate.dominio.repositorios.SituacaoRepositorio;
import com.univates.tcc.abacate.dominio.servicos.SituacaoServico;

@Service
public final class SituacaoServicoImpl 
	extends ServicoDeCrudImpl<SituacaoRepositorio, Situacao, Integer>
		implements SituacaoServico {

	@Autowired
	public SituacaoServicoImpl(SituacaoRepositorio repositorio) {
		super(repositorio);
	}
}
