package com.univates.tcc.abacate.aplicacao.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univates.tcc.abacate.dominio.entidades.Responsavel;
import com.univates.tcc.abacate.dominio.servicos.ImpressaoDeEntidades;
import com.univates.tcc.abacate.dominio.servicos.ResponsavelServico;

@RestController
@RequestMapping("/responsaveis")
@CrossOrigin
public class ResponsavelRest extends CrudAbstratoRest<Responsavel, Integer> {

	@Autowired
	public ResponsavelRest(ResponsavelServico servicoDeCrud, ImpressaoDeEntidades impressaoDeEntidades) {
		super(servicoDeCrud, impressaoDeEntidades);
	}
	
}
