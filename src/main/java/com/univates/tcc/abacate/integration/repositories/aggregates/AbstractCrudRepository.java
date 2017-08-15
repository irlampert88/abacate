package com.univates.tcc.abacate.integration.repositories.aggregates;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univates.tcc.abacate.domain.entities.AbstractEntity;

@Repository
public interface AbstractCrudRepository<E extends AbstractEntity<ID>, ID extends Serializable> 
	extends JpaRepository<E, ID> {
	
}
