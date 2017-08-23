package com.univates.tcc.abacate.aplicacao.rest;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;

@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
abstract class CrudAbstratoRest<ENTITY extends EntidadeAbstrata<PK>, PK extends Serializable> {

	private final CrudRepository<ENTITY, PK> repositorio;
	
	public CrudAbstratoRest(CrudRepository<ENTITY, PK> repositorio) {
		this.repositorio = repositorio;
	}
	
	@RequestMapping(method=RequestMethod.POST) 
	public ResponseEntity<ENTITY> save(@RequestBody ENTITY entity){
		entity = repositorio.save(entity);		
		return new ResponseEntity<ENTITY>(entity, HttpStatus.OK);
	}	
	
	@RequestMapping(method=RequestMethod.PATCH)
	public ResponseEntity<ENTITY> update(@RequestBody ENTITY entity){
		entity = repositorio.save(entity);
		return new ResponseEntity<ENTITY>(entity, HttpStatus.OK);
	}	

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<ENTITY> delete(@PathVariable("id") PK id){
		repositorio.delete(id);
		return new ResponseEntity<ENTITY>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public final ResponseEntity<ENTITY> findById(@PathVariable PK id){
		final ENTITY found = repositorio.findOne(id);
		return new ResponseEntity<ENTITY>(found, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public final ResponseEntity<Iterable<ENTITY>> findAll(){
		final Iterable<ENTITY> founds = repositorio.findAll();
		return new ResponseEntity<Iterable<ENTITY>>(founds, HttpStatus.OK);		
	}
	
}