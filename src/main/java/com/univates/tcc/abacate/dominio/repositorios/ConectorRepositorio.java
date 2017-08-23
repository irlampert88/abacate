package com.univates.tcc.abacate.dominio.repositorios;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.univates.tcc.abacate.dominio.entidades.Conector;
import com.univates.tcc.abacate.integracao.repositorios.agregadores.RepositorioDeCrudAbstrato;

@Repository
@Transactional
public interface ConectorRepositorio 
	extends RepositorioDeCrudAbstrato<Conector, Integer> {

}
