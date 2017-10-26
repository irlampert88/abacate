package com.univates.tcc.abacate.dominio.servicos.impl;

import java.io.File;
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.univates.tcc.abacate.dominio.agregadores.ObjetoParaImpressao;
import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;
import com.univates.tcc.abacate.dominio.servicos.ImpressaoDeEntidades;
import com.univates.tcc.abacate.dominio.servicos.ServicoDeCrud;
import com.univates.tcc.abacate.integracao.relatorio.GeradorDeRelatorioParaListagem;

public class ImpressaoDeRegistrosImpl
	implements ImpressaoDeEntidades {

	@Autowired
	private GeradorDeRelatorioParaListagem geradorDeRelatorioParaListagem;
	
	@Override
	public <E extends EntidadeAbstrata<ID>, ID extends Serializable> File gerarListaParaImpressao(ObjetoParaImpressao objetoParaImpressao,
			ServicoDeCrud<E, ID> servicoDeCrud) throws Exception {
		
		Iterable<E> entidadesParaImpressao = obtemListaDeRegistros(objetoParaImpressao.getEntidadeDeExemplo(), servicoDeCrud);
		
		return geradorDeRelatorioParaListagem.gerar(objetoParaImpressao.getAtributos(), entidadesParaImpressao);
	}

	private <E extends EntidadeAbstrata<ID>, ID extends Serializable> Iterable<E> obtemListaDeRegistros(
			EntidadeAbstrata<?> entidadeAbstrata, ServicoDeCrud<E, ID> servicoDeCrud) {
		
		if (entidadeAbstrata != null)
			return servicoDeCrud.buscarPeloExemplo((E) entidadeAbstrata);
		else
			return servicoDeCrud.buscarTodos();
	}

}
