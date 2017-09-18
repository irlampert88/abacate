package com.univates.tcc.abacate.dominio.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.dominio.entidades.TipoSolicitacao;
import com.univates.tcc.abacate.dominio.repositorios.TipoSolicitacaoRepositorio;
import com.univates.tcc.abacate.dominio.servicos.TipoSolicitacaoServico;
import com.univates.tcc.abacate.integracao.repositorios.agregadores.ConsultasPeloExemplo;

@Service
public final class TipoSolicitacaoServicoImpl 
	extends ServicoDeCrudImpl<TipoSolicitacaoRepositorio, TipoSolicitacao, Integer>
		implements TipoSolicitacaoServico {

	@Autowired
	public TipoSolicitacaoServicoImpl(TipoSolicitacaoRepositorio repositorio, ConsultasPeloExemplo consultaPeloExemplo) {
		super(repositorio, consultaPeloExemplo);
	}
}
