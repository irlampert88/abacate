package com.univates.tcc.abacate.dominio.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.dominio.entidades.Responsavel;
import com.univates.tcc.abacate.dominio.repositorios.ResponsavelRepositorio;
import com.univates.tcc.abacate.dominio.servicos.ResponsavelServico;

@Service
public final class ResponsavelServicoImpl 
	extends ServicoDeCrudImpl<ResponsavelRepositorio, Responsavel, Integer>
		implements ResponsavelServico {

	@Autowired
	public ResponsavelServicoImpl(ResponsavelRepositorio repositorio) {
		super(repositorio);
	}
}
