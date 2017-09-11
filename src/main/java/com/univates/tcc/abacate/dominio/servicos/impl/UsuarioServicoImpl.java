package com.univates.tcc.abacate.dominio.servicos.impl;

import java.time.LocalDateTime;
import java.util.Base64;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.dominio.entidades.Usuario;
import com.univates.tcc.abacate.dominio.excecao.AutenticacaoRequerida;
import com.univates.tcc.abacate.dominio.repositorios.UsuarioRepositorio;
import com.univates.tcc.abacate.dominio.servicos.UsuarioServico;

@Service
public final class UsuarioServicoImpl 
	extends ServicoDeCrudImpl<UsuarioRepositorio, Usuario, Integer>
		implements UsuarioServico {

	private UsuarioRepositorio repositorio;

	@Autowired
	public UsuarioServicoImpl(UsuarioRepositorio repositorio) {
		super(repositorio);
		this.repositorio = repositorio;
	}

	@Override
	public void checarToken(String token) {
		// TODO: Mudar para consultar na Sessão
		String[] usuarioESenha = extrairUsuarioESenhaDoToken(token);
		
		String usuario = usuarioESenha[0];
		String senha = usuarioESenha[1];
		
		Usuario usuarioEncontrado = repositorio.procuraUsuarioParaAutenticar(usuario, senha);
		if (usuarioEncontrado == null)
			throw new AutenticacaoRequerida("Usuário inválido.");
	}

	private String[] extrairUsuarioESenhaDoToken(String token) {
		if (StringUtils.isBlank(token))
			throw new AutenticacaoRequerida("Token para autenticação é inválido.");
		
		// TODO Remover o Basic
		String[] usuarioESenha = new String(Base64.getDecoder().decode(token.replace("Basic ", ""))).split(":");
		
		if (usuarioESenha.length != 2) 
			throw new AutenticacaoRequerida("Token para autenticação é inválido.");
		
		return usuarioESenha;
	}

	@Override
	public Usuario autenticar(Usuario usuario) {
		if (StringUtils.isBlank(usuario.getUsuario()) || StringUtils.isBlank(usuario.getSenha()))
			throw new AutenticacaoRequerida("Usuário e Senha devem ser informados para autenticação.");
		
		Usuario usuarioEncontrado = repositorio.procuraUsuarioParaAutenticar(usuario.getUsuario(), usuario.getSenha());
		if (usuarioEncontrado == null)
			throw new AutenticacaoRequerida("Usuário inválido para autenticação no Abacate.");
		
		atualizaUltimoAcesso(usuarioEncontrado);
		
		return usuarioEncontrado;
	}

	private void atualizaUltimoAcesso(Usuario usuarioEncontrado) {
		usuarioEncontrado.setUltimoAcesso(LocalDateTime.now());
		alterar(usuarioEncontrado);
	}
	
}
