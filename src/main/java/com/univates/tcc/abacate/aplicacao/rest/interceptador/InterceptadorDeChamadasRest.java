package com.univates.tcc.abacate.aplicacao.rest.interceptador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.univates.tcc.abacate.aplicacao.configuracoes.ConstantesDeConfiguracao;
import com.univates.tcc.abacate.aplicacao.rest.autorizacao.GerenciadorDeAutenticacao;
import com.univates.tcc.abacate.aplicacao.rest.permissao.GerenciadorDePermissoes;
import com.univates.tcc.abacate.dominio.entidades.Usuario;

@Component
public class InterceptadorDeChamadasRest implements HandlerInterceptor {

	private GerenciadorDeAutenticacao gerenciadorDeAutenticacao;
	private GerenciadorDePermissoes gerenciadorDePermissoes;
	private HttpSession sessao;

	@Autowired
	public InterceptadorDeChamadasRest(GerenciadorDeAutenticacao gerenciadorDeAutenticacao, GerenciadorDePermissoes gerenciadorDePermissoes, HttpSession sessao) {
		this.gerenciadorDeAutenticacao = gerenciadorDeAutenticacao;
		this.gerenciadorDePermissoes = gerenciadorDePermissoes;
		this.sessao = sessao;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (!(handler instanceof HandlerMethod))
			return true;
		
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		
		if (!handlerMethod.getBeanType().getCanonicalName().startsWith(ConstantesDeConfiguracao.Pacotes.PREFIXO))
			return true;

		Usuario usuarioDoToken = gerenciadorDeAutenticacao.autenticarToken(request, handlerMethod);
		gerenciadorDePermissoes.validarSeUsuarioPossuiPermissao(request, handlerMethod, usuarioDoToken);
		
		sessao.setAttribute(ConstantesDeConfiguracao.Sessao.USUARIO, usuarioDoToken);
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView mav) throws Exception {
	}

	@Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object handler, Exception ex) throws Exception {
    }
}