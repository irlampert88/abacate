package com.univates.tcc.abacate.dominio.servicos;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;

@Service
public interface ServicoDeCrud<E extends EntidadeAbstrata<ID>, ID extends Serializable> {

	public E inserir(E novaEntidade);
	public E alterar(E entidade);
	public void deletar(ID idDaEntidade);
	public E buscarPorId(ID idDaEntidade);
	public Collection<E> buscarTodos();
	public Collection<E> buscarTodosComPaginacao(Integer pagina, Integer quantidade, String atributoOrdenado, String ordem);
	public E buscarUmPeloExemplo(E exampleEntity);
	public Collection<E> buscarPeloExemplo(E exampleEntity);
	public Collection<E> buscarPeloExemploComPaginacao(E exampleEntity, Integer pagina, Integer quantidade, String atributoOrdenado, String ordem);
	
}
