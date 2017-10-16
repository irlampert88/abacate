package com.univates.tcc.abacate.aplicacao.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.univates.tcc.abacate.aplicacao.rest.autorizacao.RequerAutenticacao;
import com.univates.tcc.abacate.aplicacao.rest.permissao.RequerPermissao;
import com.univates.tcc.abacate.aplicacao.rest.permissao.TipoDePermissao;
import com.univates.tcc.abacate.dominio.entidades.Rack;
import com.univates.tcc.abacate.dominio.servicos.RackServico;

@RestController
@RequestMapping("/racks")
@CrossOrigin
public class RackRest extends CrudAbstratoRest<Rack, Integer> {

	private RackServico servicoDeCrud;

	@Autowired
	public RackRest(RackServico servicoDeCrud) {
		super(servicoDeCrud);
		this.servicoDeCrud = servicoDeCrud;
	}
	
	@RequerAutenticacao
	@RequerPermissao(tipoDePermissao = TipoDePermissao.CONSULTAR)
	@RequestMapping(method=RequestMethod.GET, value = "foto/{id}")
	public final ResponseEntity<String> buscarFoto(@PathVariable Integer id){
		final Rack found = servicoDeCrud.buscarPorId(id);
		return new ResponseEntity<String>(found.getFoto(), HttpStatus.OK);
	}
	
}
