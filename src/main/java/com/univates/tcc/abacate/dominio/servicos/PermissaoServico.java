package com.univates.tcc.abacate.dominio.servicos;

import java.util.Collection;

import com.univates.tcc.abacate.dominio.entidades.Permissao;
import com.univates.tcc.abacate.dominio.entidades.Usuario;

public interface PermissaoServico 
	extends ServicoDeCrud<Permissao, Integer> {

	public Permissao buscarPermissaoDoUsuarioNaTabela(Usuario usuario, String nomeDaTabela);
	public void atribuirTodasAsTabelasNasPermissoesDoUsuario(Usuario entidade);
	public Collection<Permissao> permissoesDoUsuario(Integer idDoUsuario);
	public void salvarListaDePermissoes(Collection<Permissao> permissoes);
}
