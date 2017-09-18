package com.univates.tcc.abacate.integracao.repositorios.agregadores;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;

@Repository
public interface ConsultasPeloExemplo {

	public <E extends EntidadeAbstrata<?>> E buscarUmPeloExemplo(E exampleEntity);
	public <E extends EntidadeAbstrata<?>> Collection<E> buscarPeloExemplo(E exampleEntity);
}
