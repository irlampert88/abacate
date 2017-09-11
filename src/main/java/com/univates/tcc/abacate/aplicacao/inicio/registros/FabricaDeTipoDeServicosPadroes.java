package com.univates.tcc.abacate.aplicacao.inicio.registros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univates.tcc.abacate.dominio.entidades.TipoServico;
import com.univates.tcc.abacate.dominio.servicos.TipoServicoServico;

@Component
public class FabricaDeTipoDeServicosPadroes 
	implements FabricaDeRegistroPadrao {

	@Autowired 
	private TipoServicoServico servico;

	@Override
	public void criarRegistrosPadroes() {
		if (servico.buscarTodos().isEmpty()) {
			TipoServico registro = new TipoServico();
			registro.setTipo("Tipo de Serviço ABC");
			
			servico.inserir(registro);
		}
	}

}
