package com.univates.tcc.abacate.application.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univates.tcc.abacate.domain.entities.Cabling;
import com.univates.tcc.abacate.domain.repositories.CablingRepositorio;

@RestController
@RequestMapping("/cabling")
public class CalbingRest extends AbstractCrudResource<Cabling, Integer> {

	@Autowired
	public CalbingRest(CablingRepositorio repositorio) {
		super(repositorio);
	}
	
}
