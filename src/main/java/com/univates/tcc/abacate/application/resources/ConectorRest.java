package com.univates.tcc.abacate.application.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univates.tcc.abacate.domain.entities.Conector;
import com.univates.tcc.abacate.domain.repositories.ConectorRepositorio;

@RestController
@RequestMapping("/conectores")
public class ConectorRest extends AbstractCrudResource<Conector, Integer> {

	@Autowired
	public ConectorRest(ConectorRepositorio repositorio) {
		super(repositorio);
	}
	
}
