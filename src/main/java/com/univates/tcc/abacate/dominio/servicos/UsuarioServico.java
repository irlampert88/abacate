package com.univates.tcc.abacate.dominio.servicos;

import com.univates.tcc.abacate.aplicacao.rest.permissao.TipoDePermissao;
import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;
import com.univates.tcc.abacate.dominio.entidades.Usuario;

public interface UsuarioServico extends ServicoDeCrud<Usuario, Integer> {
	
	public Usuario autenticarToken(String token);
	public Usuario autenticar(Usuario usuario);
	public void validarSeUsuarioPossuiPermissao(Usuario usuario, TipoDePermissao tipoDePermissao, Class<? extends EntidadeAbstrata<?>> classeDaEntidade);
}
