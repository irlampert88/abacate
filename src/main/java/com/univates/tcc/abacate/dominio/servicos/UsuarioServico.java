package com.univates.tcc.abacate.dominio.servicos;

import com.univates.tcc.abacate.dominio.entidades.Usuario;

public interface UsuarioServico extends ServicoDeCrud<Usuario, Integer> {
	
	public void checarToken(String token);
	public Usuario autenticar(Usuario usuario);
}
