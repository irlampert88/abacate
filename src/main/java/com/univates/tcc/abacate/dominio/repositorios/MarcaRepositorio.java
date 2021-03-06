package com.univates.tcc.abacate.dominio.repositorios;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.univates.tcc.abacate.dominio.entidades.Marca;
import com.univates.tcc.abacate.integracao.repositorios.agregadores.RepositorioDeCrud;

@Repository
@Transactional
public interface MarcaRepositorio 
	extends RepositorioDeCrud<Marca, Integer> {

}
