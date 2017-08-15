package com.univates.tcc.abacate.integration.repositories.aggregates;

import java.io.Serializable;

import com.univates.tcc.abacate.domain.entities.AbstractEntity;

public interface AbstractCrudRepositoryCustom<E extends AbstractEntity<ID>, ID extends Serializable> {

	public E findOneByExample(E exampleEntity);
	public Iterable<E> findByExample(E exampleEntity);
}
