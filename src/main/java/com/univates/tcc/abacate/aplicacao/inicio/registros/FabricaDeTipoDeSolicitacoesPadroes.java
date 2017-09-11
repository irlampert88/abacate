package com.univates.tcc.abacate.aplicacao.inicio.registros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univates.tcc.abacate.dominio.entidades.TipoSolicitacao;
import com.univates.tcc.abacate.dominio.servicos.TipoSolicitacaoServico;

@Component
public class FabricaDeTipoDeSolicitacoesPadroes 
	implements FabricaDeRegistroPadrao {

	@Autowired 
	private TipoSolicitacaoServico servico;

	@Override
	public void criarRegistrosPadroes() {
		if (servico.buscarTodos().isEmpty()) {
			TipoSolicitacao registro = new TipoSolicitacao();
			registro.setTipo("Tipo de Solicitação ABC");
			
			servico.inserir(registro);
		}
	}

}
