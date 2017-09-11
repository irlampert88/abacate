package com.univates.tcc.abacate.aplicacao.inicio.registros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univates.tcc.abacate.dominio.entidades.Marca;
import com.univates.tcc.abacate.dominio.servicos.MarcaServico;

@Component
public class FabricaDeMarcasPadroes 
	implements FabricaDeRegistroPadrao {

	@Autowired 
	private MarcaServico servico;

	@Override
	public void criarRegistrosPadroes() {
		if (servico.buscarTodos().isEmpty()) {
			Marca registro = new Marca();
			registro.setDescricao("Marca ABC");
			
			servico.inserir(registro);
		}
	}

}
