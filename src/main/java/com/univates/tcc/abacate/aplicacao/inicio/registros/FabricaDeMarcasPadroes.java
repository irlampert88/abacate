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
			Marca registro1 = new Marca();
			registro1.setDescricao("AMarca ABC");
			servico.inserir(registro1);
			
			Marca registro2 = new Marca();
			registro2.setDescricao("BMarca ABC");
			servico.inserir(registro2);
			
			Marca registro3 = new Marca();
			registro3.setDescricao("CMarca ABC");
			servico.inserir(registro3);
			
			Marca registro4 = new Marca();
			registro4.setDescricao("DMarca ABC");
			servico.inserir(registro4);
			
			Marca registro5 = new Marca();
			registro5.setDescricao("EMarca ABC");
			servico.inserir(registro5);
		}
	}

}
