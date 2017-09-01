package com.univates.tcc.abacate.aplicacao.inicio;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univates.tcc.abacate.dominio.entidades.Usuario;
import com.univates.tcc.abacate.dominio.servicos.UsuarioServico;

@Component
public class RegistrosPadroesParaBancoDeDados {

	@Autowired
	private UsuarioServico usuarioServico;
	
	public void popularBancoDeDados() {
		popularComUsuarios();
	}

	private void popularComUsuarios() {
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
