package com.univates.tcc.abacate.dominio.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.dominio.entidades.TipoServico;
import com.univates.tcc.abacate.dominio.repositorios.TipoServicoRepositorio;
import com.univates.tcc.abacate.dominio.servicos.TipoServicoServico;

@Service
public final class TipoServicoServicoImpl 
	extends ServicoDeCrudImpl<TipoServicoRepositorio, TipoServico, Integer>
		implements TipoServicoServico {

	@Autowired
	public TipoServicoServicoImpl(TipoServicoRepositorio repositorio) {
		super(repositorio);
	}
}
