package com.univates.tcc.abacate.dominio.servicos.impl;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;
import com.univates.tcc.abacate.dominio.servicos.ServicoDeCrud;
import com.univates.tcc.abacate.integracao.repositorios.agregadores.RepositorioDeCrud;

@Service
@Transactional
class ServicoDeCrudImpl<R extends RepositorioDeCrud<E, ID>, E extends EntidadeAbstrata<ID>, ID extends Serializable> 
	implements ServicoDeCrud<E, ID> {

	private final R repositorio;
	
	public ServicoDeCrudImpl(R repositorio) {
		this.repositorio = repositorio;
	}
	
	@Override
	@Transactional(readOnly = false)
	public E inserir(E novaEntidade) {
		return repositorio.save(novaEntidade);
	}

	@Override
	@Transactional(readOnly = false)
	public E alterar(E entidade) {
		return repositorio.save(entidade);
	}

	@Override
	@Transactional(readOnly = false)
	public void deletar(ID idDaEntidade) {
		repositorio.delete(idDaEntidade);
	}

	@Override
	public E buscarPorId(ID idDaEntidade) {
		return repositorio.findOne(idDaEntidade);
	}

	@Override
	public Collection<E> buscarTodos() {
		return repositorio.findAll();
	}

}
