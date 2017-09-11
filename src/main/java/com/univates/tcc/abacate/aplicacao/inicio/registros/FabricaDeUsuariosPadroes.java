package com.univates.tcc.abacate.aplicacao.inicio.registros;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univates.tcc.abacate.dominio.entidades.Usuario;
import com.univates.tcc.abacate.dominio.servicos.UsuarioServico;

@Component
public class FabricaDeUsuariosPadroes 
	implements FabricaDeRegistroPadrao {
	
	@Autowired
	private UsuarioServico usuarioServico;

	@Override
	public void criarRegistrosPadroes() {
		if (usuarioServico.buscarTodos().isEmpty()) {
			Usuario usuarioPadrao = new Usuario();
			usuarioPadrao.setNome("Usuário Abacate");
			usuarioPadrao.setAtivo(1);
			usuarioPadrao.setEmail("admin@admi.admin");
			usuarioPadrao.setSenha("admin");
			usuarioPadrao.setUsuario("admin");
			usuarioPadrao.setUltimoAcesso(LocalDateTime.now());
			
			usuarioServico.inserir(usuarioPadrao);
		}
	}

}
