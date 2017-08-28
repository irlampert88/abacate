package com.univates.tcc.abacate.aplicacao.rest;

import static com.univates.tcc.abacate.dominio.utilitarios.IdentificadorDeGenerics.PRIMEIRO_GENERIC;
import static com.univates.tcc.abacate.dominio.utilitarios.IdentificadorDeGenerics.identificaClasseDeUmGeneric;
import static com.univates.tcc.abacate.dominio.utilitarios.InstanciadorDeObjetos.criaInstancia;

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
abstract class CrudAbstratoRest<ENTIDADE extends EntidadeAbstrata<ID>, ID extends Serializable> {

	private final ServicoDeCrud<ENTIDADE, ID> servicoDeCrud;
	
	public CrudAbstratoRest(ServicoDeCrud<ENTIDADE, ID> servicoDeCrud) {
		this.servicoDeCrud = servicoDeCrud;
	}
	
	@RequestMapping(method=RequestMethod.POST) 
	public final ResponseEntity<ENTIDADE> save(@RequestBody ENTIDADE entity){
		entity = servicoDeCrud.inserir(entity);		
		return new ResponseEntity<ENTIDADE>(entity, HttpStatus.OK);
	}	
	
	@RequestMapping(method=RequestMethod.PATCH)
	public final ResponseEntity<ENTIDADE> update(@RequestBody ENTIDADE entity){
		entity = servicoDeCrud.alterar(entity);
		return new ResponseEntity<ENTIDADE>(entity, HttpStatus.OK);
	}	

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public final ResponseEntity<ID> delete(@PathVariable("id") ID id){
		servicoDeCrud.deletar(id);
		return new ResponseEntity<ID>(id, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public final ResponseEntity<ENTIDADE> findById(@PathVariable ID id){
		final ENTIDADE found = servicoDeCrud.buscarPorId(id);
		return new ResponseEntity<ENTIDADE>(found, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public final ResponseEntity<Iterable<ENTIDADE>> findAll(){
		final Iterable<ENTIDADE> founds = servicoDeCrud.buscarTodos();
		return new ResponseEntity<Iterable<ENTIDADE>>(founds, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/estrutura", method=RequestMethod.GET)
	public final ResponseEntity<ENTIDADE> exibirEstrutura(){
		final Class<?> classeDaEntidade = identificaClasseDeUmGeneric(getClass(), PRIMEIRO_GENERIC);
		final ENTIDADE instanciaVaziaDaEntidade = (ENTIDADE) criaInstancia(classeDaEntidade);
	
		return new ResponseEntity<ENTIDADE>(instanciaVaziaDaEntidade, HttpStatus.OK);
	}
	
}
