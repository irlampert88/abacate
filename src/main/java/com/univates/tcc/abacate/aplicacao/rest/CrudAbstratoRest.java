package com.univates.tcc.abacate.aplicacao.rest;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;
import com.univates.tcc.abacate.dominio.servicos.ServicoDeCrud;

@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
abstract class CrudAbstratoRest<ENTITY extends EntidadeAbstrata<ID>, ID extends Serializable> {

	private final ServicoDeCrud<ENTITY, ID> servicoDeCrud;
	
	public CrudAbstratoRest(ServicoDeCrud<ENTITY, ID> servicoDeCrud) {
		this.servicoDeCrud = servicoDeCrud;
	}
	
	@RequestMapping(method=RequestMethod.POST) 
	public final ResponseEntity<ENTITY> save(@RequestBody ENTITY entity){
		entity = servicoDeCrud.inserir(entity);		
		return new ResponseEntity<ENTITY>(entity, HttpStatus.OK);
	}	
	
	@RequestMapping(method=RequestMethod.PATCH)
	public final ResponseEntity<ENTITY> update(@RequestBody ENTITY entity){
		entity = servicoDeCrud.alterar(entity);
		return new ResponseEntity<ENTITY>(entity, HttpStatus.OK);
	}	

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public final ResponseEntity<ID> delete(@PathVariable("id") ID id){
		servicoDeCrud.deletar(id);
		return new ResponseEntity<ID>(id, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public final ResponseEntity<ENTITY> findById(@PathVariable ID id){
		final ENTITY found = servicoDeCrud.buscarPorId(id);
		return new ResponseEntity<ENTITY>(found, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public final ResponseEntity<Iterable<ENTITY>> findAll(){
		final Iterable<ENTITY> founds = servicoDeCrud.buscarTodos();
		return new ResponseEntity<Iterable<ENTITY>>(founds, HttpStatus.OK);		
	}
	
}
