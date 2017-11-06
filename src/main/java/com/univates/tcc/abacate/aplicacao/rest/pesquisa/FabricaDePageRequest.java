package com.univates.tcc.abacate.aplicacao.rest.pesquisa;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public class FabricaDePageRequest {

	private FabricaDePageRequest() {
	}

	public static PageRequest criar(Integer pagina, Integer quantidade, String atributoOrdenado, String ordem) {
		pagina = pagina == null ? 0 : pagina;
		quantidade = quantidade == null ? Integer.MAX_VALUE : quantidade;
		
		if (atributoOrdenado == null) 
			return new PageRequest(pagina, quantidade);
		
		return new PageRequest(pagina, quantidade, new Sort(Direction.fromString(ordem), atributoOrdenado));
	}

}
