package com.univates.tcc.abacate.application.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univates.tcc.abacate.domain.entities.Terminacao;
import com.univates.tcc.abacate.domain.repositories.TerminacaoRepositorio;

@RestController
@RequestMapping("/terminacoes")
public class TerminacaoRest extends AbstractCrudResource<Terminacao, Integer> {

	@Autowired
	public TerminacaoRest(TerminacaoRepositorio repositorio) {
		super(repositorio);
	}
	
}
