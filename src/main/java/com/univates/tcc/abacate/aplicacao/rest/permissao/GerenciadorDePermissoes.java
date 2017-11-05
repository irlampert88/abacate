package com.univates.tcc.abacate.aplicacao.rest.permissao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;
import com.univates.tcc.abacate.dominio.entidades.Usuario;
import com.univates.tcc.abacate.dominio.servicos.UsuarioServico;
import com.univates.tcc.abacate.dominio.utilitarios.IdentificadorDeGenerics;

@Component
public class GerenciadorDePermissoes {

	private UsuarioServico usuarioServico;
	
	@Autowired
	public GerenciadorDePermissoes(UsuarioServico usuarioServico) {
		this.usuarioServico = usuarioServico;
	}
	
	public final boolean validarSeUsuarioPossuiPermissao(HttpServletRequest request, HandlerMethod handlerMethod, Usuario usuarioDoToken) {
		if (usuarioDoToken == null)
			return true;
		
		RequerPermissao permissaoRequerida = handlerMethod.getMethod().getAnnotation(RequerPermissao.class);

		if (permissaoRequerida == null) {
			return true;
		}

		usuarioServico.validarSeUsuarioPossuiPermissao(usuarioDoToken, permissaoRequerida.tipoDePermissao(), classeDaEntidade(handlerMethod));
		
		return true;
	}

	private Class<? extends EntidadeAbstrata<?>> classeDaEntidade(HandlerMethod handlerMethod) {
		Class<?> classe = handlerMethod.getBeanType();
		Class<?> classeDaEntidade = IdentificadorDeGenerics.identificaClasseDeUmGeneric(classe, IdentificadorDeGenerics.PRIMEIRO_GENERIC);
		return (Class<? extends EntidadeAbstrata<?>>) classeDaEntidade;
	}

}