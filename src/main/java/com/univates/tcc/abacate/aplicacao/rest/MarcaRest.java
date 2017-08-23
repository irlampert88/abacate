package com.univates.tcc.abacate.aplicacao.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univates.tcc.abacate.dominio.entidades.Marca;
import com.univates.tcc.abacate.dominio.repositorios.MarcaRepositorio;

@RestController
@RequestMapping("/marcas")
@CrossOrigin
public class MarcaRest extends CrudAbstratoRest<Marca, Integer> {

	@Autowired
	public MarcaRest(MarcaRepositorio repositorio) {
		super(repositorio);
	}
	
}
