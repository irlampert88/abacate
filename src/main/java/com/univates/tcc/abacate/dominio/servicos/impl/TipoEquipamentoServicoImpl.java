package com.univates.tcc.abacate.dominio.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.dominio.entidades.TipoEquipamento;
import com.univates.tcc.abacate.dominio.repositorios.TipoEquipamentoRepositorio;
import com.univates.tcc.abacate.dominio.servicos.TipoEquipamentoServico;
import com.univates.tcc.abacate.integracao.repositorios.agregadores.ConsultasPeloExemplo;

@Service
public final class TipoEquipamentoServicoImpl 
	extends ServicoDeCrudImpl<TipoEquipamentoRepositorio, TipoEquipamento, Integer>
		implements TipoEquipamentoServico {

	@Autowired
	public TipoEquipamentoServicoImpl(TipoEquipamentoRepositorio repositorio, ConsultasPeloExemplo consultaPeloExemplo) {
		super(repositorio, consultaPeloExemplo);
	}
}
