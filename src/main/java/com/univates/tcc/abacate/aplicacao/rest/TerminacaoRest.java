package com.univates.tcc.abacate.aplicacao.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univates.tcc.abacate.dominio.entidades.Terminacao;
import com.univates.tcc.abacate.dominio.repositorios.TerminacaoRepositorio;

@RestController
@RequestMapping("/terminacoes")
@CrossOrigin
public class TerminacaoRest extends CrudAbstratoRest<Terminacao, Integer> {

	@Autowired
	public TerminacaoRest(TerminacaoRepositorio repositorio) {
		super(repositorio);
	}
	
}
