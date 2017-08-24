package com.univates.tcc.abacate.aplicacao.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univates.tcc.abacate.dominio.entidades.Equipamento;
import com.univates.tcc.abacate.dominio.servicos.EquipamentoServico;

@RestController
@RequestMapping("/equipamentos")
@CrossOrigin
public class EquipamentoRest extends CrudAbstratoRest<Equipamento, Integer> {

	@Autowired
	public EquipamentoRest(EquipamentoServico servicoDeCrud) {
		super(servicoDeCrud);
	}
	
}
