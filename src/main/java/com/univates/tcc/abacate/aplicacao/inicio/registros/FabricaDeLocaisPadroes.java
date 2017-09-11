package com.univates.tcc.abacate.aplicacao.inicio.registros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univates.tcc.abacate.dominio.entidades.Local;
import com.univates.tcc.abacate.dominio.servicos.LocalServico;
import com.univates.tcc.abacate.dominio.servicos.ResponsavelServico;

@Component
public class FabricaDeLocaisPadroes 
	implements FabricaDeRegistroPadrao {

	@Autowired 
	private LocalServico servico;
	
	@Autowired
	private ResponsavelServico responsavelServico;

	@Override
	public void criarRegistrosPadroes() {
		if (servico.buscarTodos().isEmpty()) {
			Local registro = new Local();
			registro.setAndar(1);
			registro.setPredio(1);
			registro.setLocal("Local ABC");
			registro.setResponsavel(responsavelServico.buscarTodos().stream().findFirst().get());
			
			servico.inserir(registro);
		}
	}

}
