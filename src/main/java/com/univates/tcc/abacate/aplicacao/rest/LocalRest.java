package com.univates.tcc.abacate.aplicacao.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univates.tcc.abacate.dominio.entidades.Local;
import com.univates.tcc.abacate.dominio.servicos.LocalServico;

@RestController
@RequestMapping("/locais")
@CrossOrigin
public class LocalRest extends CrudAbstratoRest<Local, Integer> {

	@Autowired
	public LocalRest(LocalServico servicoDeCrud) {
		super(servicoDeCrud);
	}
	
}
