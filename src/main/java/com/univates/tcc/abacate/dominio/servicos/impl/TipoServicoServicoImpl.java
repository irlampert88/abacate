package com.univates.tcc.abacate.dominio.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.dominio.entidades.TipoServico;
import com.univates.tcc.abacate.dominio.repositorios.TipoServicoRepositorio;
import com.univates.tcc.abacate.dominio.servicos.TipoServicoServico;
import com.univates.tcc.abacate.integracao.repositorios.agregadores.ConsultasPeloExemplo;

@Service
public final class TipoServicoServicoImpl 
	extends ServicoDeCrudImpl<TipoServicoRepositorio, TipoServico, Integer>
		implements TipoServicoServico {

	@Autowired
	public TipoServicoServicoImpl(TipoServicoRepositorio repositorio, ConsultasPeloExemplo consultaPeloExemplo) {
		super(repositorio, consultaPeloExemplo);
	}
}
