package com.univates.tcc.abacate.aplicacao.inicio.registros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univates.tcc.abacate.dominio.entidades.TipoRack;
import com.univates.tcc.abacate.dominio.servicos.TipoRackServico;

@Component
public class FabricaDeTipoDeRacksPadroes 
	implements FabricaDeRegistroPadrao {
	
	@Autowired 
	private TipoRackServico servico;

	@Override
	public void criarRegistrosPadroes() {
		if (servico.buscarTodos().isEmpty()) {
			TipoRack registro = new TipoRack();
			registro.setTipo("Tipo de Rack ABC");
			
			servico.inserir(registro);
		}
	}

}
