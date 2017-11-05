package com.univates.tcc.abacate.dominio.servicos.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.univates.tcc.abacate.aplicacao.configuracoes.ConstantesDeConfiguracao;
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

	private HttpSession sessao;

	@Autowired
	public RegistroLogServicoImpl(RegistroLogRepositorio repositorio, ConsultasPeloExemplo consultaPeloExemplo,  HttpSession sessao) {
		super(repositorio, consultaPeloExemplo);
		this.sessao = sessao;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public <E extends EntidadeAbstrata<?>> void registrarLog(E entidade, Acoes acao) {
		if (registroDePermissao(entidade) || registroDeLogParaUsuario(entidade))
			return;
		
		Usuario usuarioLogado = buscaUsuarioLogado();
		if (usuarioLogado != null) {
			RegistroLog novoLog = new ConstrutorDeRegistroLog()
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
		return (Usuario) sessao.getAttribute(ConstantesDeConfiguracao.Sessao.USUARIO);
	}
	
}
