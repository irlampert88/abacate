package com.univates.tcc.abacate.application.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univates.tcc.abacate.domain.entities.Marca;
import com.univates.tcc.abacate.domain.repositories.MarcaRepositorio;

@RestController
@RequestMapping("/marcas")
public class MarcaRest extends AbstractCrudResource<Marca, Integer> {

	@Autowired
	public MarcaRest(MarcaRepositorio repositorio) {
		super(repositorio);
	}
	
}
