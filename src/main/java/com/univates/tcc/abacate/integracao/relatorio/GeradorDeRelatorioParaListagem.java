package com.univates.tcc.abacate.integracao.relatorio;

import java.io.File;
import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;

@Component
public interface GeradorDeRelatorioParaListagem {

	<E extends EntidadeAbstrata<ID>, ID extends Serializable> byte[] 
		gerar(Iterable<String> atributosParaListar, Iterable<E> entidadesParaImpressao) throws Exception;
}
