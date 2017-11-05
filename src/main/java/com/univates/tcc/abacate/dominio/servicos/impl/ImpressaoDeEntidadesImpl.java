package com.univates.tcc.abacate.dominio.servicos.impl;

import java.io.File;
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.io.Files;
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
	public <E extends EntidadeAbstrata<ID>, ID extends Serializable> File gerarListaParaImpressao(ObjetoParaImpressao objetoParaImpressao,
			Integer pagina, Integer quantidade, String atributoOrdenado, String ordem, ServicoDeCrud<E, ID> servicoDeCrud) throws Exception {
		
		Iterable<E> entidadesParaImpressao = obtemListaDeRegistros(objetoParaImpressao.getEntidadeDeExemplo(), pagina, quantidade, atributoOrdenado, ordem, servicoDeCrud);
		
		byte[] conteudo = geradorDeRelatorioParaListagem.gerar(objetoParaImpressao.getAtributos(), objetoParaImpressao.getTitulos(), entidadesParaImpressao);
		
		File arquivoPdf = File.createTempFile("Abacate", String.valueOf(System.currentTimeMillis()));
		Files.write(conteudo, arquivoPdf);
		
		return arquivoPdf;
	}

	private <E extends EntidadeAbstrata<ID>, ID extends Serializable> Iterable<E> obtemListaDeRegistros(EntidadeAbstrata entidadeAbstrata, Integer pagina, Integer quantidade,
			String atributoOrdenado, String ordem, ServicoDeCrud<E, ID> servicoDeCrud) {

		pagina = pagina == null ? 0 : pagina;
		quantidade = quantidade == null ? Integer.MAX_VALUE : quantidade;
		
		if (entidadeAbstrata != null) {
			return servicoDeCrud.buscarPeloExemploComPaginacao((E) entidadeAbstrata, pagina, quantidade, atributoOrdenado, ordem);
			
		} else {
			return servicoDeCrud.buscarTodosComPaginacao(pagina, quantidade, atributoOrdenado, ordem);
			
		}
	}

}
