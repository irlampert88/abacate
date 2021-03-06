package com.univates.tcc.abacate.dominio.construtores;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Table;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.GsonBuilder;
import com.univates.tcc.abacate.dominio.agregadores.Acoes;
import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;
import com.univates.tcc.abacate.dominio.entidades.RegistroLog;
import com.univates.tcc.abacate.dominio.entidades.Usuario;
import com.univates.tcc.abacate.dominio.utilitarios.IdentificadorDeAnotacoes;

public class ConstrutorDeRegistroLog implements Serializable {

	private static final long serialVersionUID = 1L;

	private final RegistroLog log;
	
	public ConstrutorDeRegistroLog() {
		this.log = new RegistroLog();
		this.log.setDataHora(LocalDateTime.now());
	}
	
	public <E extends EntidadeAbstrata<?>> ConstrutorDeRegistroLog paraEntidade(E entidade) {
		log.setDado(jsonDaEntidade(entidade));
		log.setTabela(buscaNomeDaTabela(entidade));
		return this;
	}

	private <E extends EntidadeAbstrata<?>> String jsonDaEntidade(E entidade) {
		Object cloneDaEntidade = entidade.clone();
		return new GsonBuilder()
				.setExclusionStrategies(new ExclusionStrategy() {
					
					@Override
					public boolean shouldSkipField(FieldAttributes f) {
						return IdentificadorDeAnotacoes.possuiFoto(f.getAnnotations());
					}
					
					@Override
					public boolean shouldSkipClass(Class<?> clazz) {
						return false;
					}
				})
				.create().toJson(cloneDaEntidade);
 	}

	private <E extends EntidadeAbstrata<?>> String buscaNomeDaTabela(E entidade) {
		Table anotacao = entidade.getClass().getAnnotation(Table.class);
		return anotacao.name();
	}

	public ConstrutorDeRegistroLog daAcao(Acoes acao) {
		log.setAcao(acao.toString());
		return this;
	}

	public ConstrutorDeRegistroLog paraUsuarioLogado(Usuario usuarioLogado) {
		log.setUsuario(usuarioLogado);
		return this;
	}

	public RegistroLog criar() {
		return log;
	}
	
}
