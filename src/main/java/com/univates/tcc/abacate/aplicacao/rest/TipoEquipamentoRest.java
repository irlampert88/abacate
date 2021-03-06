package com.univates.tcc.abacate.aplicacao.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univates.tcc.abacate.dominio.entidades.TipoEquipamento;
import com.univates.tcc.abacate.dominio.servicos.ImpressaoDeEntidades;
import com.univates.tcc.abacate.dominio.servicos.TipoEquipamentoServico;

@RestController
@RequestMapping("/tipos_equipamentos")
@CrossOrigin
public class TipoEquipamentoRest extends CrudAbstratoRest<TipoEquipamento, Integer> {

	@Autowired
	public TipoEquipamentoRest(TipoEquipamentoServico servicoDeCrud, ImpressaoDeEntidades impressaoDeEntidades) {
		super(servicoDeCrud, impressaoDeEntidades);
	}
	
}
