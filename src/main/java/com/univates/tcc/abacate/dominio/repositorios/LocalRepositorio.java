package com.univates.tcc.abacate.dominio.repositorios;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.univates.tcc.abacate.dominio.entidades.Local;
import com.univates.tcc.abacate.integracao.repositorios.agregadores.RepositorioDeCrud;

@Repository
@Transactional
public interface LocalRepositorio 
	extends RepositorioDeCrud<Local, Integer> {

}
