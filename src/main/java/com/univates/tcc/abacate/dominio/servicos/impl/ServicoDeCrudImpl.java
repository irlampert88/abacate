package com.univates.tcc.abacate.dominio.servicos.impl;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.univates.tcc.abacate.aplicacao.rest.pesquisa.FabricaDePageRequest;
import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;
import com.univates.tcc.abacate.dominio.servicos.ServicoDeCrud;
import com.univates.tcc.abacate.integracao.repositorios.agregadores.ConsultasPeloExemplo;
import com.univates.tcc.abacate.integracao.repositorios.agregadores.RepositorioDeCrud;

@Service
@Transactional
class ServicoDeCrudImpl<R extends RepositorioDeCrud<E, ID>, E extends EntidadeAbstrata<ID>, ID extends Serializable> 
	implements ServicoDeCrud<E, ID> {

	private final R repositorio;
	
	private ConsultasPeloExemplo consultaPeloExemplo;
	
	public ServicoDeCrudImpl(R repositorio, ConsultasPeloExemplo consultaPeloExemplo) {
		this.repositorio = repositorio;
		this.consultaPeloExemplo = consultaPeloExemplo;
	}
	
	@Override
	@Transactional(readOnly = false)
	public final E inserir(E novaEntidade) {
		return repositorio.saveAndFlush(novaEntidade);
	}

	@Override
	@Transactional(readOnly = false)
	public final E alterar(E entidade) {
		return repositorio.saveAndFlush(entidade);
	}

	@Override
	@Transactional(readOnly = false)
	public final void deletar(ID idDaEntidade) {
		repositorio.delete(idDaEntidade);
	}

	@Override
	public final E buscarPorId(ID idDaEntidade) {
		return repositorio.findOne(idDaEntidade);
	}

	@Override
	public final Collection<E> buscarTodos() {
		return repositorio.findAll();
	}
	
	@Override
	public final E buscarUmPeloExemplo(E exampleEntity) {
		return consultaPeloExemplo.buscarUmPeloExemplo(exampleEntity);
	}
	
	@Override
	public final Collection<E> buscarPeloExemplo(E exampleEntity) {
		return consultaPeloExemplo.buscarPeloExemplo(exampleEntity);
	}

	@Override
	public Collection<E> buscarTodosComPaginacao(Integer pagina, Integer quantidade, String atributoOrdenado, String ordem) {
		Page<E> paginaComRegistros = repositorio.findAll(FabricaDePageRequest.criar(pagina, quantidade, atributoOrdenado, ordem));
		return paginaComRegistros.getContent();
	}

	@Override
	public Collection<E> buscarPeloExemploComPaginacao(E exampleEntity, Integer pagina, Integer quantidade, String atributoOrdenado, String ordem) {
		return consultaPeloExemplo.buscarPeloExemploComPaginacao(exampleEntity, pagina, quantidade, atributoOrdenado, ordem);
	}

}
