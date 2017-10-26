package com.univates.tcc.abacate.dominio.servicos;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.univates.tcc.abacate.dominio.agregadores.ObjetoParaImpressao;
import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;

@Component
public interface ImpressaoDeEntidades 
	extends Serializable {

	public <E extends EntidadeAbstrata<ID>, ID extends Serializable> byte[] 
		gerarListaParaImpressao(ObjetoParaImpressao objetoParaImpressao, Integer pagina, Integer quantidade,
				String atributoOrdenado, String ordem, ServicoDeCrud<E, ID> servicoDeCrud)
			throws Exception;

}
