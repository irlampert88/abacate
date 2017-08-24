package com.univates.tcc.abacate.dominio.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.dominio.entidades.Equipamento;
import com.univates.tcc.abacate.dominio.repositorios.EquipamentoRepositorio;
import com.univates.tcc.abacate.dominio.servicos.EquipamentoServico;

@Service
public final class EquipamentoServicoImpl 
	extends ServicoDeCrudImpl<EquipamentoRepositorio, Equipamento, Integer>
		implements EquipamentoServico {

	@Autowired
	public EquipamentoServicoImpl(EquipamentoRepositorio repositorio) {
		super(repositorio);
	}
}
