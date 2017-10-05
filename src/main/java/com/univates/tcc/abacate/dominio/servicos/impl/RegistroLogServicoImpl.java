package com.univates.tcc.abacate.dominio.servicos.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.univates.tcc.abacate.aplicacao.apis.JsonApi;
import com.univates.tcc.abacate.dominio.agregadores.Acoes;
import com.univates.tcc.abacate.dominio.construtores.ConstrutorDeRegistroLog;
import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;
import com.univates.tcc.abacate.dominio.entidades.Permissao;
import com.univates.tcc.abacate.dominio.entidades.RegistroLog;
import com.univates.tcc.abacate.dominio.entidades.Usuario;
import com.univates.tcc.abacate.dominio.repositorios.RegistroLogRepositorio;
import com.univates.tcc.abacate.dominio.repositorios.UsuarioRepositorio;
import com.univates.tcc.abacate.dominio.servicos.RegistroLogServico;
import com.univates.tcc.abacate.integracao.repositorios.agregadores.ConsultasPeloExemplo;

@Service
@Transactional
public final class RegistroLogServicoImpl 
	extends ServicoDeCrudImpl<RegistroLogRepositorio, RegistroLog, Integer>
		implements RegistroLogServico {

	@Autowired
	private UsuarioRepositorio repositorioTEMPORARIO; // TODO REMOVER ISSO!!!!
	
	private JsonApi jsonApi;

	@Autowired
	public RegistroLogServicoImpl(RegistroLogRepositorio repositorio, JsonApi jsonApi, ConsultasPeloExemplo consultaPeloExemplo) {
		super(repositorio, consultaPeloExemplo);
		this.jsonApi = jsonApi;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public <E extends EntidadeAbstrata<?>> void registrarLog(E entidade, Acoes acao) {
		if (registroDePermissao(entidade) || registroDeLogParaUsuario(entidade))
			return;
		
		Usuario usuarioLogado = buscaUsuarioLogado();
		if (usuarioLogado != null) {
			RegistroLog novoLog = new ConstrutorDeRegistroLog(jsonApi)
					.paraUsuarioLogado(usuarioLogado).paraEntidade(entidade).daAcao(acao).criar();
			inserir(novoLog);
		}
	}

	private <E extends EntidadeAbstrata<?>> boolean registroDePermissao(E entidade) {
		return entidade instanceof Permissao;
	}

	private <E extends EntidadeAbstrata<?>> boolean registroDeLogParaUsuario(E entidade) {
		return entidade instanceof Usuario;
	}

	private Usuario buscaUsuarioLogado() {
		// TODO Mudar para Sessão?
		List<Usuario> usuarios = repositorioTEMPORARIO.findAll();
		return usuarios.isEmpty() ? null : usuarios.get(0);
	}
	
}
