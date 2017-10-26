package com.univates.tcc.abacate.aplicacao.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univates.tcc.abacate.dominio.entidades.TipoSolicitacao;
import com.univates.tcc.abacate.dominio.servicos.ImpressaoDeEntidades;
import com.univates.tcc.abacate.dominio.servicos.TipoSolicitacaoServico;

@RestController
@RequestMapping("/tipos_solicitacoes")
@CrossOrigin
public class TipoSolicitacaoRest extends CrudAbstratoRest<TipoSolicitacao, Integer> {

	@Autowired
	public TipoSolicitacaoRest(TipoSolicitacaoServico servicoDeCrud, ImpressaoDeEntidades impressaoDeEntidades) {
		super(servicoDeCrud, impressaoDeEntidades);
	}
	
}
