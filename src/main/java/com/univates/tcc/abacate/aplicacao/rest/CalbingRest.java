package com.univates.tcc.abacate.aplicacao.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univates.tcc.abacate.dominio.entidades.Cabling;
import com.univates.tcc.abacate.dominio.servicos.CablingServico;
import com.univates.tcc.abacate.dominio.servicos.ImpressaoDeEntidades;

@RestController
@RequestMapping("/cabling")
@CrossOrigin
public class CalbingRest extends CrudAbstratoRest<Cabling, Integer> {

	@Autowired
	public CalbingRest(CablingServico servicoDeCrud, ImpressaoDeEntidades impressaoDeEntidades) {
		super(servicoDeCrud, impressaoDeEntidades);
	}
	
}
