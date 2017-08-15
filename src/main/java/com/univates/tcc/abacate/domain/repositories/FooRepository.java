package com.univates.tcc.abacate.domain.repositories;

import org.springframework.stereotype.Repository;

import com.univates.tcc.abacate.domain.entities.Foo;
import com.univates.tcc.abacate.integration.repositories.aggregates.AbstractCrudRepository;

@Repository
public interface FooRepository 
	extends AbstractCrudRepository<Foo, Long> {

}
