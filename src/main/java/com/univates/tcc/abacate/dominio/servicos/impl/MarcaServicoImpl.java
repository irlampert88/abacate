package com.univates.tcc.abacate.dominio.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.dominio.entidades.Marca;
import com.univates.tcc.abacate.dominio.repositorios.MarcaRepositorio;
import com.univates.tcc.abacate.dominio.servicos.MarcaServico;
import com.univates.tcc.abacate.integracao.repositorios.agregadores.ConsultasPeloExemplo;

@Service
public final class MarcaServicoImpl 
	extends ServicoDeCrudImpl<MarcaRepositorio, Marca, Integer>
		implements MarcaServico {

	@Autowired
	public MarcaServicoImpl(MarcaRepositorio repositorio, ConsultasPeloExemplo consultaPeloExemplo) {
		super(repositorio, consultaPeloExemplo);
	}
}
