package com.univates.tcc.abacate.dominio.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.dominio.entidades.TipoSolicitacao;
import com.univates.tcc.abacate.dominio.repositorios.TipoSolicitacaoRepositorio;
import com.univates.tcc.abacate.dominio.servicos.TipoSolicitacaoServico;

@Service
public final class TipoSolicitacaoServicoImpl 
	extends ServicoDeCrudImpl<TipoSolicitacaoRepositorio, TipoSolicitacao, Integer>
		implements TipoSolicitacaoServico {

	@Autowired
	public TipoSolicitacaoServicoImpl(TipoSolicitacaoRepositorio repositorio) {
		super(repositorio);
	}
}
