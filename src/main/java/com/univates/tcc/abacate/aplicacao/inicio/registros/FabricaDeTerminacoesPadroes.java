package com.univates.tcc.abacate.aplicacao.inicio.registros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univates.tcc.abacate.dominio.entidades.Terminacao;
import com.univates.tcc.abacate.dominio.servicos.TerminacaoServico;

@Component
public class FabricaDeTerminacoesPadroes 
	implements FabricaDeRegistroPadrao {

	@Autowired 
	private TerminacaoServico servico;

	@Override
	public void criarRegistrosPadroes() {
		if (servico.buscarTodos().isEmpty()) {
			Terminacao registro = new Terminacao();
			registro.setTerminacao("Terminação ABC");
			
			servico.inserir(registro);
		}
	}

}
