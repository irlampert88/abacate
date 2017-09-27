package com.univates.tcc.abacate.aplicacao.rest.pesquisa;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.util.StringUtils;

import com.univates.tcc.abacate.dominio.excecoes.ValoresInvalidos;

public class FabricaDePageRequest {

	private FabricaDePageRequest() {
	}

	public static PageRequest criar(Integer pagina, Integer quantidade, String atributoOrdenado, String ordem) {
		validarParametros(pagina, quantidade);
		if (naoPossuiOrdenacao(atributoOrdenado))
			return new PageRequest(pagina, quantidade);
			
		return new PageRequest(pagina, quantidade, new Sort(Direction.fromString(ordem), atributoOrdenado));
	}

	private static boolean naoPossuiOrdenacao(String atributoOrdenado) {
		return StringUtils.isEmpty(atributoOrdenado);
	}

	private static void validarParametros(Integer pagina, Integer quantidade) {
		if (pagina == null || quantidade == null)
			throw new ValoresInvalidos("Página e Quantidade são valoroes requeridos paginação");
	}
	
}
