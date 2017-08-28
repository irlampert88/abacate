package com.univates.tcc.abacate.aplicacao.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univates.tcc.abacate.dominio.entidades.Solicitacao;
import com.univates.tcc.abacate.dominio.servicos.SolicitacaoServico;

@RestController
@RequestMapping("/solicitacoes")
@CrossOrigin
public class SolicitacaoRest extends CrudAbstratoRest<Solicitacao, Integer> {

	@Autowired
	public SolicitacaoRest(SolicitacaoServico servicoDeCrud) {
		super(servicoDeCrud);
	}
	
}
