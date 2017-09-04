package com.univates.tcc.abacate.dominio.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.univates.tcc.abacate.aplicacao.apis.JsonApi;
import com.univates.tcc.abacate.dominio.agregadores.Acoes;
import com.univates.tcc.abacate.dominio.construtores.ConstrutorDeRegistroLog;
import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;
import com.univates.tcc.abacate.dominio.entidades.RegistroLog;
import com.univates.tcc.abacate.dominio.entidades.Usuario;
import com.univates.tcc.abacate.dominio.repositorios.RegistroLogRepositorio;
import com.univates.tcc.abacate.dominio.repositorios.UsuarioRepositorio;
import com.univates.tcc.abacate.dominio.servicos.RegistroLogServico;

@Service
@Transactional
public final class RegistroLogServicoImpl 
	extends ServicoDeCrudImpl<RegistroLogRepositorio, RegistroLog, Integer>
		implements RegistroLogServico {

	@Autowired
	private UsuarioRepositorio repositorioTEMPORARIO; // TODO REMOVER ISSO!!!!
	
	private JsonApi jsonApi;

	@Autowired
	public RegistroLogServicoImpl(RegistroLogRepositorio repositorio, JsonApi jsonApi) {
		super(repositorio);
		this.jsonApi = jsonApi;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public <E extends EntidadeAbstrata<?>> void registrarLog(E entidade, Acoes acao) {
		if (naoPossuiUsuario() && registroDeLogParaUsuario(entidade))
			return;
		
		RegistroLog novoLog = new ConstrutorDeRegistroLog(jsonApi)
				.paraUsuarioLogado(buscaUsuarioLogado()).paraEntidade(entidade).daAcao(acao).criar();
		inserir(novoLog);
	}

	private <E extends EntidadeAbstrata<?>> boolean registroDeLogParaUsuario(E entidade) {
		return entidade instanceof Usuario;
	}

	private boolean naoPossuiUsuario() {
		// TODO Mudar para Count
		return repositorioTEMPORARIO.findAll().isEmpty();
	}

	private Usuario buscaUsuarioLogado() {
		// TODO Mudar para Sessão?
		return repositorioTEMPORARIO.findAll().get(0);
	}
	
}
