package com.univates.tcc.abacate.integracao.repositorios.agregadores;

import java.io.Serializable;

import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;

public interface RepositorioDeCrudCustomizadoAbstrato<E extends EntidadeAbstrata<ID>, ID extends Serializable> {

	public E buscarUmPeloExemplo(E exampleEntity);
	public Iterable<E> buscarPeloExemplo(E exampleEntity);
}
