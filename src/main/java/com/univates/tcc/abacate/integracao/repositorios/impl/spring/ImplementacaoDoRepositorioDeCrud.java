package com.univates.tcc.abacate.integracao.repositorios.impl.spring;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;
import com.univates.tcc.abacate.integracao.repositorios.agregadores.RepositorioDeCrudCustomizadoAbstrato;

public class ImplementacaoDoRepositorioDeCrud<E extends EntidadeAbstrata<ID>, ID extends Serializable>
	implements RepositorioDeCrudCustomizadoAbstrato<E, ID> {

	private EntityManager entityManager;
	
	@Autowired
	public ImplementacaoDoRepositorioDeCrud(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public E buscarUmPeloExemplo(E exampleEntity) {
//		Example example = Example.create(exampleEntity);
//		Session session = entityManager.unwrap(Session.class);
//		session.createCriteria(exampleEntity.getClass()).add(example);
		
		System.out.println("FIND ONE BY EXAMPLE");
		return null;
	}

	@Override
	public Iterable<E> buscarPeloExemplo(E exampleEntity) {
		System.out.println("FIND ALL BY EXAMPLE");
		return null;
	}

}
