package com.univates.tcc.abacate.dominio.servicos.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univates.tcc.abacate.dominio.agregadores.ObjetoParaImpressao;
import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;
import com.univates.tcc.abacate.dominio.servicos.ImpressaoDeEntidades;
import com.univates.tcc.abacate.dominio.servicos.ServicoDeCrud;
import com.univates.tcc.abacate.integracao.relatorio.GeradorDeRelatorioParaListagem;

@Component
public class ImpressaoDeEntidadesImpl
	implements ImpressaoDeEntidades {

	private static final long serialVersionUID = 1L;

	@Autowired
	private GeradorDeRelatorioParaListagem geradorDeRelatorioParaListagem;
	
	@Override
	public <E extends EntidadeAbstrata<ID>, ID extends Serializable> byte[] gerarListaParaImpressao(ObjetoParaImpressao objetoParaImpressao,
			Integer pagina, Integer quantidade, String atributoOrdenado, String ordem, ServicoDeCrud<E, ID> servicoDeCrud) throws Exception {
		
		Iterable<E> entidadesParaImpressao = obtemListaDeRegistros(objetoParaImpressao.getEntidadeDeExemplo(), pagina, quantidade, atributoOrdenado, ordem, servicoDeCrud);
		
		return geradorDeRelatorioParaListagem.gerar(objetoParaImpressao.getAtributos(), entidadesParaImpressao);
	}

	private <E extends EntidadeAbstrata<ID>, ID extends Serializable> Iterable<E> obtemListaDeRegistros(
			EntidadeAbstrata<?> entidadeAbstrata, Integer pagina, Integer quantidade,
			String atributoOrdenado, String ordem, ServicoDeCrud<E, ID> servicoDeCrud) {

		final boolean comPaginacao = pagina != null && quantidade != null;
		
		if (entidadeAbstrata != null) {
			if (comPaginacao)
				return servicoDeCrud.buscarPeloExemploComPaginacao((E) entidadeAbstrata, pagina, quantidade, atributoOrdenado, ordem);
		
			return servicoDeCrud.buscarPeloExemplo((E) entidadeAbstrata);
		} else {
			if (comPaginacao)
				return servicoDeCrud.buscarTodosComPaginacao(pagina, quantidade, atributoOrdenado, ordem);
			
			return servicoDeCrud.buscarTodos();
		}
	}

}
