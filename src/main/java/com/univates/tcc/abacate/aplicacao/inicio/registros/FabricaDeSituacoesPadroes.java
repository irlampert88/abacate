package com.univates.tcc.abacate.aplicacao.inicio.registros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univates.tcc.abacate.dominio.entidades.Situacao;
import com.univates.tcc.abacate.dominio.servicos.SituacaoServico;

@Component
public class FabricaDeSituacoesPadroes 
	implements FabricaDeRegistroPadrao {

	@Autowired 
	private SituacaoServico servico;

	@Override
	public void criarRegistrosPadroes() {
		if (servico.buscarTodos().isEmpty()) {
			Situacao registro = new Situacao();
			registro.setSituacao("Situação ABC");
			
			servico.inserir(registro);
		}
	}

}
