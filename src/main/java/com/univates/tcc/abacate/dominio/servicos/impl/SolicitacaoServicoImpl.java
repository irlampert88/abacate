package com.univates.tcc.abacate.dominio.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.dominio.entidades.Solicitacao;
import com.univates.tcc.abacate.dominio.repositorios.SolicitacaoRepositorio;
import com.univates.tcc.abacate.dominio.servicos.SolicitacaoServico;

@Service
public final class SolicitacaoServicoImpl 
	extends ServicoDeCrudImpl<SolicitacaoRepositorio, Solicitacao, Integer>
		implements SolicitacaoServico {

	@Autowired
	public SolicitacaoServicoImpl(SolicitacaoRepositorio repositorio) {
		super(repositorio);
	}
}
