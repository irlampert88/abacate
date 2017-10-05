package com.univates.tcc.abacate.dominio.servicos.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;
import com.univates.tcc.abacate.dominio.entidades.Permissao;
import com.univates.tcc.abacate.dominio.entidades.Usuario;
import com.univates.tcc.abacate.dominio.fabricas.FabricaDePermissao;
import com.univates.tcc.abacate.dominio.repositorios.PermissaoRepositorio;
import com.univates.tcc.abacate.dominio.servicos.PermissaoServico;
import com.univates.tcc.abacate.dominio.utilitarios.LocalizadorDeClasses;
import com.univates.tcc.abacate.integracao.repositorios.agregadores.ConsultasPeloExemplo;

@Service
public final class PermissaoServicoImpl 
	extends ServicoDeCrudImpl<PermissaoRepositorio, Permissao, Integer>
		implements PermissaoServico {

	private PermissaoRepositorio repositorio;

	@Autowired
	public PermissaoServicoImpl(PermissaoRepositorio repositorio, ConsultasPeloExemplo consultaPeloExemplo) {
		super(repositorio, consultaPeloExemplo);
		this.repositorio = repositorio;
	}

	@Override
	public Permissao buscarPermissaoDoUsuarioNaTabela(Usuario usuario, String nomeDaTabela) {
		return repositorio.buscarPermissaoDoUsuarioNaTabela(usuario.getId(), nomeDaTabela);
	}

	@Override
	public void atribuirTodasAsTabelasNasPermissoesDoUsuario(Usuario usuario) {
		Iterable<Class<EntidadeAbstrata<?>>> entidades = LocalizadorDeClasses.todasEntidades();
		Set<Permissao> permissoesDoUsuario = listaDePermissoesParaAsEntidades(entidades, usuario);
		usuario.setPermissoes(permissoesDoUsuario);
	}

	private <CLASSE extends EntidadeAbstrata<?>> Set<Permissao> listaDePermissoesParaAsEntidades(Iterable<Class<CLASSE>> entidades, Usuario usuario) {
		final Set<Permissao> permissoes = new HashSet<>();
		for (Class<CLASSE> classeDaEntidade : entidades) {
			Permissao novaPermissao = FabricaDePermissao.criarParaEntidade(classeDaEntidade);
			novaPermissao.setUsuario(usuario);
			permissoes.add(novaPermissao);
		}
		return permissoes;
	}
}
