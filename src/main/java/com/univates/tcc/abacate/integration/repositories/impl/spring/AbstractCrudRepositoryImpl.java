package com.univates.tcc.abacate.integration.repositories.impl.spring;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.univates.tcc.abacate.domain.entities.AbstractEntity;
import com.univates.tcc.abacate.integration.repositories.aggregates.AbstractCrudRepositoryCustom;

public class AbstractCrudRepositoryImpl<E extends AbstractEntity<ID>, ID extends Serializable>
	implements AbstractCrudRepositoryCustom<E, ID> {

	private EntityManager entityManager;
	
	@Autowired
	public AbstractCrudRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public E findOneByExample(E exampleEntity) {
//		Example example = Example.create(exampleEntity);
//		Session session = entityManager.unwrap(Session.class);
//		session.createCriteria(exampleEntity.getClass()).add(example);
		
		System.out.println("FIND ONE BY EXAMPLE");
		return null;
	}

	@Override
	public Iterable<E> findByExample(E exampleEntity) {
		System.out.println("FIND ALL BY EXAMPLE");
		return null;
	}

}
