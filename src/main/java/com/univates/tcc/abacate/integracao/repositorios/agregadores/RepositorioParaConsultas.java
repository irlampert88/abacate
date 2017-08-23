package com.univates.tcc.abacate.integracao.repositorios.agregadores;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;

@Repository
public interface RepositorioParaConsultas<E extends EntidadeAbstrata<ID>, ID extends Serializable> {

	public E buscarUmPeloExemplo(E exampleEntity);
	public Collection<E> buscarPeloExemplo(E exampleEntity);
}
