package com.univates.tcc.abacate.integracao.repositorios.impl.spring;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;
import com.univates.tcc.abacate.integracao.repositorios.agregadores.RepositorioParaConsultas;

@Repository
public class RepositorioParaConsultasImpl<E extends EntidadeAbstrata<ID>, ID extends Serializable>
	implements RepositorioParaConsultas<E, ID> {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public E buscarUmPeloExemplo(E exampleEntity) {
//		Example example = Example.create(exampleEntity);
//		Session session = entityManager.unwrap(Session.class);
//		session.createCriteria(exampleEntity.getClass()).add(example);
		
		System.out.println("FIND ONE BY EXAMPLE");
		return null;
	}

	@Override
	public Collection<E> buscarPeloExemplo(E exampleEntity) {
		System.out.println("FIND ALL BY EXAMPLE");
		return null;
	}

}
