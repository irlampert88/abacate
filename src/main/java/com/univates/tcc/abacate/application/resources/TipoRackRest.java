package com.univates.tcc.abacate.application.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univates.tcc.abacate.domain.entities.TipoRack;
import com.univates.tcc.abacate.domain.repositories.TipoRackRepositorio;

@RestController
@RequestMapping("/tipos_racks")
public class TipoRackRest extends AbstractCrudResource<TipoRack, Integer> {

	@Autowired
	public TipoRackRest(TipoRackRepositorio repositorio) {
		super(repositorio);
	}
	
}
