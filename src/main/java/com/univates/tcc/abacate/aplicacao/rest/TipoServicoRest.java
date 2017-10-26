package com.univates.tcc.abacate.aplicacao.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univates.tcc.abacate.dominio.entidades.TipoServico;
import com.univates.tcc.abacate.dominio.servicos.ImpressaoDeEntidades;
import com.univates.tcc.abacate.dominio.servicos.TipoServicoServico;

@RestController
@RequestMapping("/tipos_servicos")
@CrossOrigin
public class TipoServicoRest extends CrudAbstratoRest<TipoServico, Integer> {

	@Autowired
	public TipoServicoRest(TipoServicoServico servicoDeCrud, ImpressaoDeEntidades impressaoDeEntidades) {
		super(servicoDeCrud, impressaoDeEntidades);
	}
	
}
