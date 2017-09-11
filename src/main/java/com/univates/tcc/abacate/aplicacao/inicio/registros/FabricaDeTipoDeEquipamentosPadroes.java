package com.univates.tcc.abacate.aplicacao.inicio.registros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univates.tcc.abacate.dominio.entidades.TipoEquipamento;
import com.univates.tcc.abacate.dominio.servicos.TipoEquipamentoServico;

@Component
public class FabricaDeTipoDeEquipamentosPadroes 
	implements FabricaDeRegistroPadrao {

	@Autowired 
	private TipoEquipamentoServico servico;

	@Override
	public void criarRegistrosPadroes() {
		if (servico.buscarTodos().isEmpty()) {
			TipoEquipamento registro = new TipoEquipamento();
			registro.setTipo("Tipo de Equipamento ABC");
			
			servico.inserir(registro);
		}
	}

}
