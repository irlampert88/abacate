package com.univates.tcc.abacate.aplicacao.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univates.tcc.abacate.dominio.entidades.Rack;
import com.univates.tcc.abacate.dominio.servicos.RackServico;

@RestController
@RequestMapping("/racks")
@CrossOrigin
public class RackRest extends CrudAbstratoRest<Rack, Integer> {

	@Autowired
	public RackRest(RackServico servicoDeCrud) {
		super(servicoDeCrud);
	}
	
}
