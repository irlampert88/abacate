package com.univates.tcc.abacate.dominio.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.dominio.entidades.Permissao;
import com.univates.tcc.abacate.dominio.entidades.Usuario;
import com.univates.tcc.abacate.dominio.repositorios.PermissaoRepositorio;
import com.univates.tcc.abacate.dominio.servicos.PermissaoServico;
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
}
