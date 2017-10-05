package com.univates.tcc.abacate.dominio.construtores;

import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.time.LocalDateTime;

import javax.persistence.Table;

import com.univates.tcc.abacate.aplicacao.apis.JsonApi;
import com.univates.tcc.abacate.dominio.agregadores.Acoes;
import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;
import com.univates.tcc.abacate.dominio.entidades.RegistroLog;
import com.univates.tcc.abacate.dominio.entidades.Usuario;

public class ConstrutorDeRegistroLog implements Serializable {

	private static final long serialVersionUID = 1L;

	private final RegistroLog log;
	private final JsonApi jsonApi;
	
	public ConstrutorDeRegistroLog(JsonApi jsonApi) {
		this.jsonApi = jsonApi;
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
		removerArquivosDaEntidade(cloneDaEntidade);
		return jsonApi.paraJson(cloneDaEntidade);
 	}
	
	private void removerArquivosDaEntidade(Object cloneDaEntidade) {
		for (Field campo : cloneDaEntidade.getClass().getDeclaredFields()) {
			if (campo.getType().equals(File.class)) {
				campo.setAccessible(true);
				try {
					campo.set(cloneDaEntidade, null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
 		}
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
