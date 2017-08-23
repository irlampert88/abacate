package com.univates.tcc.abacate.aplicacao.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin
public class AbacateRest {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index() {
		return "Bem vindo ao Abacate!";
	}

}
