package com.univates.tcc.abacate.dominio.servicos.impl;

import java.time.LocalDateTime;
import java.util.Base64;

import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.aplicacao.rest.permissao.TipoDePermissao;
import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;
import com.univates.tcc.abacate.dominio.entidades.Permissao;
import com.univates.tcc.abacate.dominio.entidades.Usuario;
import com.univates.tcc.abacate.dominio.excecoes.AutenticacaoRequerida;
import com.univates.tcc.abacate.dominio.excecoes.SemPermissao;
import com.univates.tcc.abacate.dominio.excecoes.UsuarioInvalido;
import com.univates.tcc.abacate.dominio.repositorios.UsuarioRepositorio;
import com.univates.tcc.abacate.dominio.servicos.PermissaoServico;
import com.univates.tcc.abacate.dominio.servicos.UsuarioServico;
import com.univates.tcc.abacate.integracao.repositorios.agregadores.ConsultasPeloExemplo;

@Service
public final class UsuarioServicoImpl 
	extends ServicoDeCrudImpl<UsuarioRepositorio, Usuario, Integer>
		implements UsuarioServico {

	private UsuarioRepositorio repositorio;
	private PermissaoServico permissaoServico;

	@Autowired
	public UsuarioServicoImpl(UsuarioRepositorio repositorio, ConsultasPeloExemplo consultaPeloExemplo, PermissaoServico permissaoServico) {
		super(repositorio, consultaPeloExemplo);
		this.repositorio = repositorio;
		this.permissaoServico = permissaoServico;
	}

	@Override
	public Usuario autenticarToken(String token) {
		String[] usuarioESenha = extrairUsuarioESenhaDoToken(token);
		
		String usuario = usuarioESenha[0];
		String senha = usuarioESenha[1];
		
		Usuario usuarioEncontrado = repositorio.procuraUsuarioParaAutenticar(usuario, senha);
		if (usuarioEncontrado == null)
			throw new AutenticacaoRequerida("Usuário inválido.");
		
		return usuarioEncontrado;
	}

	private String[] extrairUsuarioESenhaDoToken(String token) {
		if (StringUtils.isBlank(token))
			throw new AutenticacaoRequerida("Token para autenticação é inválido.");
		
		String[] usuarioESenha = new String(Base64.getDecoder().decode(token)).split(":");
		
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

	@Override
	public void validarSeUsuarioPossuiPermissao(Usuario usuario, TipoDePermissao tipoDePermissao, Class<? extends EntidadeAbstrata<?>> classeDaEntidade) {
		if (naoPossuiPermissao(tipoDePermissao, usuario, nomeDaTablea(classeDaEntidade)))
			throw new SemPermissao("Usuário " + usuario.getNome() + " não possui permissao de " + tipoDePermissao.toString() + " na tabela " + nomeDaTablea(classeDaEntidade));
	}

	private boolean naoPossuiPermissao(TipoDePermissao tipoDePermissao, Usuario usuario, String nomeDaTabela) {
		Permissao permissaoDaTabela = permissaoServico.buscarPermissaoDoUsuarioNaTabela(usuario, nomeDaTabela);
		return permissaoDaTabela != null && !tipoDePermissao.possuiPermissao(permissaoDaTabela);
	}

	private String nomeDaTablea(Class<? extends EntidadeAbstrata<?>> classeDaEntidade) {
		Table tabela = classeDaEntidade.getAnnotation(Table.class);
		return tabela.name();
	}

	@Override
	public Usuario resetarSenha(Usuario usuarioComNovaSenha) {
		Usuario usuarioComSenhaAtualizada = repositorio.procuraUsuarioParaResetDeSenha(usuarioComNovaSenha.getUsuario(), usuarioComNovaSenha.getEmail());
		
		if (usuarioComSenhaAtualizada == null)
			throw new UsuarioInvalido("Usuário não encontrado com o usuario " + usuarioComNovaSenha.getUsuario() + " e e-mail " + usuarioComNovaSenha.getEmail());
		
		usuarioComSenhaAtualizada.setSenha(usuarioComNovaSenha.getSenha());

		return usuarioComSenhaAtualizada;
	}
}
