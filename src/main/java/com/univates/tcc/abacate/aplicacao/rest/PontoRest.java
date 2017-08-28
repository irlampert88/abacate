package com.univates.tcc.abacate.aplicacao.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univates.tcc.abacate.dominio.entidades.Ponto;
import com.univates.tcc.abacate.dominio.servicos.PontoServico;

@RestController
@RequestMapping("/pontos")
@CrossOrigin
public class PontoRest extends CrudAbstratoRest<Ponto, Integer> {

	@Autowired
	public PontoRest(PontoServico servicoDeCrud) {
		super(servicoDeCrud);
	}
	
}
