package com.univates.tcc.abacate.aplicacao.rest.autorizacao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import com.univates.tcc.abacate.aplicacao.configuracoes.ConstantesDeConfiguracao;
import com.univates.tcc.abacate.dominio.entidades.Usuario;
import com.univates.tcc.abacate.dominio.servicos.UsuarioServico;

@Component
public class GerenciadorDeAutenticacao {

	private UsuarioServico usuarioServico;
	
	@Autowired
	public GerenciadorDeAutenticacao(UsuarioServico usuarioServico) {
		this.usuarioServico = usuarioServico;
	}
	
	public final Usuario autenticarToken(HttpServletRequest request, HandlerMethod handler) {
		RequerAutenticacao requerAutorizacao = handler.getMethod().getAnnotation(RequerAutenticacao.class);
		
		if (naoRequerAutenticacao(requerAutorizacao)) {
			return null;
		}

		return usuarioServico.autenticarToken(request.getHeader(ConstantesDeConfiguracao.Autenticacao.TOKEN));
	}

	private boolean naoRequerAutenticacao(RequerAutenticacao requerAutorizacao) {
		return requerAutorizacao == null;
	}

}