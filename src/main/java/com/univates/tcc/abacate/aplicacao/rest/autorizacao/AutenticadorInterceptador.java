package com.univates.tcc.abacate.aplicacao.rest.autorizacao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.univates.tcc.abacate.aplicacao.configuracoes.ConstantesDeConfiguracao;
import com.univates.tcc.abacate.dominio.servicos.UsuarioServico;

@Component
public class AutenticadorInterceptador implements HandlerInterceptor {

	private UsuarioServico usuarioServico;
	
	@Autowired
	public AutenticadorInterceptador(UsuarioServico usuarioServico) {
		this.usuarioServico = usuarioServico;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (!(handler instanceof HandlerMethod))
			return true;
		
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		RequerAutenticacao requerAutorizacao = handlerMethod.getMethod().getAnnotation(RequerAutenticacao.class);
		if (requerAutorizacao == null) {
			return true;
		}

		usuarioServico.checarToken(request.getHeader(ConstantesDeConfiguracao.Autenticacao.TOKEN));
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView mav) throws Exception {
	}

	@Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object handler, Exception ex) throws Exception {
    }
}