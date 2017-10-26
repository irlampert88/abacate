package com.univates.tcc.abacate.dominio.servicos;

import java.io.File;
import java.io.Serializable;

import com.univates.tcc.abacate.dominio.agregadores.ObjetoParaImpressao;
import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;

public interface ImpressaoDeEntidades {

	public <E extends EntidadeAbstrata<ID>, ID extends Serializable> File 
		gerarListaParaImpressao(ObjetoParaImpressao objetoParaImpressao, ServicoDeCrud<E, ID> servicoDeCrud)
			throws Exception;
}
