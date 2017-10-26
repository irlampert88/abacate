package com.univates.tcc.abacate.aplicacao.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univates.tcc.abacate.dominio.entidades.Foo;
import com.univates.tcc.abacate.dominio.servicos.FooService;
import com.univates.tcc.abacate.dominio.servicos.ImpressaoDeEntidades;

@RestController
@RequestMapping("/foo")
@CrossOrigin
public class FooResource extends CrudAbstratoRest<Foo, Long> {

	@Autowired
	public FooResource(FooService servicoDeCrud, ImpressaoDeEntidades impressaoDeEntidades) {
		super(servicoDeCrud, impressaoDeEntidades);
	}
	
}
