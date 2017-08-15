package com.univates.tcc.abacate.application.resources;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.univates.tcc.abacate.domain.entities.AbstractEntity;

@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
abstract class AbstractCrudResource<ENTITY extends AbstractEntity<PK>, PK extends Serializable> {

	private final CrudRepository<ENTITY, PK> repository;
	
	public AbstractCrudResource(CrudRepository<ENTITY, PK> repository) {
		this.repository = repository;
	}
	
	@RequestMapping(method=RequestMethod.POST) 
	public final ResponseEntity<ENTITY> save(@RequestBody ENTITY entity){
		entity = repository.save(entity);		
		return new ResponseEntity<ENTITY>(entity, HttpStatus.OK);
	}	
	
	@RequestMapping(method=RequestMethod.PUT)
	public final ResponseEntity<ENTITY> update(@RequestBody ENTITY entity){
		entity = repository.save(entity);
		return new ResponseEntity<ENTITY>(entity, HttpStatus.OK);
	}	

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public final ResponseEntity<ENTITY> delete(@PathVariable("id") PK id){
		repository.delete(id);
		return new ResponseEntity<ENTITY>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public final ResponseEntity<ENTITY> findById(@PathVariable PK id){
		ENTITY found = repository.findOne(id);
		return new ResponseEntity<ENTITY>(found, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public final ResponseEntity<Iterable<ENTITY>> findAll(){
		Iterable<ENTITY> founds = repository.findAll();
		return new ResponseEntity<Iterable<ENTITY>>(founds, HttpStatus.OK);		
	}
	
}
