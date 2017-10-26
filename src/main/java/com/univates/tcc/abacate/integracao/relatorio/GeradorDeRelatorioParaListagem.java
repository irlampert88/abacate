package com.univates.tcc.abacate.integracao.relatorio;

import java.io.File;
import java.io.Serializable;

import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;

public interface GeradorDeRelatorioParaListagem {

	<E extends EntidadeAbstrata<ID>, ID extends Serializable> File 
		gerar(Iterable<String> atributosParaListar, Iterable<E> entidadesParaImpressao) throws Exception;
}
