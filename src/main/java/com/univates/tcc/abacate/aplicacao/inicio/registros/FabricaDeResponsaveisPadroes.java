package com.univates.tcc.abacate.aplicacao.inicio.registros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univates.tcc.abacate.dominio.entidades.Responsavel;
import com.univates.tcc.abacate.dominio.servicos.ResponsavelServico;

@Component
public class FabricaDeResponsaveisPadroes 
	implements FabricaDeRegistroPadrao {
	
	@Autowired 
	private ResponsavelServico servico;

	@Override
	public void criarRegistrosPadroes() {
		if (servico.buscarTodos().isEmpty()) {
			Responsavel registro = new Responsavel();
			registro.setAtivo(1);
			registro.setEmail("responsavel@abacate.com.br");
			registro.setNome("Responsavel ABC");
			registro.setRamal(123);
			registro.setSenha("admin");
			
			servico.inserir(registro);
		}
	}

}
