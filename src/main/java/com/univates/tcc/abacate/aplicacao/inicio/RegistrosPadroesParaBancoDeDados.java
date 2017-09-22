package com.univates.tcc.abacate.aplicacao.inicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univates.tcc.abacate.aplicacao.inicio.registros.FabricaDeCalbingPadroes;
import com.univates.tcc.abacate.aplicacao.inicio.registros.FabricaDeLocaisPadroes;
import com.univates.tcc.abacate.aplicacao.inicio.registros.FabricaDeMarcasPadroes;
import com.univates.tcc.abacate.aplicacao.inicio.registros.FabricaDePermissoesPadroes;
import com.univates.tcc.abacate.aplicacao.inicio.registros.FabricaDeResponsaveisPadroes;
import com.univates.tcc.abacate.aplicacao.inicio.registros.FabricaDeSituacoesPadroes;
import com.univates.tcc.abacate.aplicacao.inicio.registros.FabricaDeTerminacoesPadroes;
import com.univates.tcc.abacate.aplicacao.inicio.registros.FabricaDeTipoDeEquipamentosPadroes;
import com.univates.tcc.abacate.aplicacao.inicio.registros.FabricaDeTipoDeRacksPadroes;
import com.univates.tcc.abacate.aplicacao.inicio.registros.FabricaDeTipoDeServicosPadroes;
import com.univates.tcc.abacate.aplicacao.inicio.registros.FabricaDeTipoDeSolicitacoesPadroes;
import com.univates.tcc.abacate.aplicacao.inicio.registros.FabricaDeUsuariosPadroes;

@Component
public class RegistrosPadroesParaBancoDeDados {

	@Autowired
	private FabricaDeUsuariosPadroes fabricaDeUsuarios;
	
	@Autowired
	private FabricaDeCalbingPadroes fabricaDeCalbing;
	
	@Autowired
	private FabricaDeResponsaveisPadroes fabricaDeResponsaveis;
	
	@Autowired
	private FabricaDeMarcasPadroes fabricaDeMarcas;
	
	@Autowired
	private FabricaDeTerminacoesPadroes fabricaDeTerminacoes;
	
	@Autowired
	private FabricaDeTipoDeEquipamentosPadroes fabricaDeTipoDeEquipamentos;
	
	@Autowired
	private FabricaDeTipoDeRacksPadroes fabricaDeTipoDeRacks;
	
	@Autowired
	private FabricaDeLocaisPadroes fabricaDeLocais;
	
	@Autowired
	private FabricaDeSituacoesPadroes fabricaDeSituacoes;
	
	@Autowired
	private FabricaDeTipoDeSolicitacoesPadroes fabricaDeTipoDeSolicitacoes;
	
	@Autowired
	private FabricaDeTipoDeServicosPadroes fabricaDeTipoDeServicos;
	
	@Autowired
	private FabricaDePermissoesPadroes fabricaDePermissoes;
	
	public void popularBancoDeDados() {
		fabricaDeUsuarios.criarRegistrosPadroes();
		fabricaDeResponsaveis.criarRegistrosPadroes();
		fabricaDeCalbing.criarRegistrosPadroes();
		fabricaDeLocais.criarRegistrosPadroes();
		fabricaDeMarcas.criarRegistrosPadroes();
		fabricaDeTerminacoes.criarRegistrosPadroes();
		fabricaDeTipoDeEquipamentos.criarRegistrosPadroes();
		fabricaDeTipoDeRacks.criarRegistrosPadroes();
		fabricaDeSituacoes.criarRegistrosPadroes();
		fabricaDeTipoDeSolicitacoes.criarRegistrosPadroes();
		fabricaDeTipoDeServicos.criarRegistrosPadroes();
		fabricaDePermissoes.criarRegistrosPadroes();
	}

}
