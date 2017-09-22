package com.univates.tcc.abacate.aplicacao.rest.interceptador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.univates.tcc.abacate.aplicacao.rest.autorizacao.GerenciadorDeAutenticacao;
import com.univates.tcc.abacate.aplicacao.rest.permissao.GerenciadorDePermissoes;
import com.univates.tcc.abacate.dominio.entidades.Usuario;

@Component
public class InterceptadorDeChamadasRest implements HandlerInterceptor {

	private GerenciadorDeAutenticacao gerenciadorDeAutenticacao;
	private GerenciadorDePermissoes gerenciadorDePermissoes;

	@Autowired
	public InterceptadorDeChamadasRest(GerenciadorDeAutenticacao gerenciadorDeAutenticacao, GerenciadorDePermissoes gerenciadorDePermissoes) {
		this.gerenciadorDeAutenticacao = gerenciadorDeAutenticacao;
		this.gerenciadorDePermissoes = gerenciadorDePermissoes;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (!(handler instanceof HandlerMethod))
			return true;
		
		HandlerMethod handlerMethod = (HandlerMethod) handler;

		Usuario usuarioDoToken = gerenciadorDeAutenticacao.autenticarToken(request, handlerMethod);
		gerenciadorDePermissoes.validarSeUsuarioPossuiPermissao(request, handlerMethod, usuarioDoToken);
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView mav) throws Exception {
	}

	@Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object handler, Exception ex) throws Exception {
    }
}