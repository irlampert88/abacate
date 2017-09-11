package com.univates.tcc.abacate.aplicacao.inicio.registros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univates.tcc.abacate.dominio.entidades.Cabling;
import com.univates.tcc.abacate.dominio.servicos.CablingServico;

@Component
public class FabricaDeCalbingPadroes 
	implements FabricaDeRegistroPadrao {
	
	@Autowired 
	private CablingServico servico;

	@Override
	public void criarRegistrosPadroes() {
		if (servico.buscarTodos().isEmpty()) {
			Cabling registro = new Cabling();
			registro.setCabling("Cabling ABC");
			
			servico.inserir(registro);
		}
	}

}
