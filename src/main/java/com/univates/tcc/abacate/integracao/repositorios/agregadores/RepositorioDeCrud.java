package com.univates.tcc.abacate.integracao.repositorios.agregadores;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;

@Repository
public interface RepositorioDeCrud<E extends EntidadeAbstrata<ID>, ID extends Serializable> 
	extends JpaRepository<E, ID> {
	
}
