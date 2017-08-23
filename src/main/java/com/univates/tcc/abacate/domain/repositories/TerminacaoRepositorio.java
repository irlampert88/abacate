package com.univates.tcc.abacate.domain.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.univates.tcc.abacate.domain.entities.Terminacao;
import com.univates.tcc.abacate.integration.repositories.aggregates.AbstractCrudRepository;

@Repository
@Transactional
public interface TerminacaoRepositorio 
	extends AbstractCrudRepository<Terminacao, Integer> {

}
