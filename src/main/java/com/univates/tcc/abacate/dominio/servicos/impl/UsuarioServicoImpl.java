package com.univates.tcc.abacate.dominio.servicos.impl;

import java.util.Base64;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.dominio.entidades.Usuario;
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
		if (StringUtils.isBlank(token))
			throw new IllegalArgumentException("Necessário autenticar na aplicação");
		
		String[] usuarioESenha = new String(Base64.getDecoder().decode(token)).split(":");
		
		if (usuarioESenha.length != 2) 
			throw new IllegalArgumentException("Token para autenticação é inválido.");
		
		String usuario = usuarioESenha[0];
		String senha = usuarioESenha[1];
		
		Usuario usuarioEncontrado = repositorio.procuraUsuarioParaAutenticar(usuario, senha);
		if (usuarioEncontrado == null) {
			throw new IllegalArgumentException("Usuário inválido");
		}
	}

	@Override
	public Usuario autenticar(Usuario usuario) {
		
		return null;
	}
	
}
