package com.univates.tcc.abacate.aplicacao.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univates.tcc.abacate.dominio.entidades.Conector;
import com.univates.tcc.abacate.dominio.repositorios.ConectorRepositorio;

@RestController
@RequestMapping("/conectores")
@CrossOrigin
public class ConectorRest extends CrudAbstratoRest<Conector, Integer> {

	@Autowired
	public ConectorRest(ConectorRepositorio repositorio) {
		super(repositorio);
	}
	
}
