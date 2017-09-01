package com.univates.tcc.abacate.integracao.repositorios.ouvintes;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.springframework.beans.factory.annotation.Autowired;

import com.univates.tcc.abacate.dominio.agregadores.Acoes;
import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;
import com.univates.tcc.abacate.dominio.servicos.RegistroLogServico;
import com.univates.tcc.abacate.integracao.spring.AutowireHelper;

@SuppressWarnings("all")
public class OuvinteRegistroDeLog {
	
	@Autowired
	private RegistroLogServico registroLog;
	
	@PrePersist
    public <E extends EntidadeAbstrata<?>> void antesDeInserir(Object entidade){
		AutowireHelper.autowire(this);
		registroLog.registrarLog((E) entidade, Acoes.INSERIR);
	}
	
	@PreUpdate
    public <E extends EntidadeAbstrata<?>> void antesDeAlterar(Object entidade){
		AutowireHelper.autowire(this);
		registroLog.registrarLog((E) entidade, Acoes.ALTERAR);
	}
	
	@PreRemove
    public <E extends EntidadeAbstrata<?>> void antesDeDeletar(Object entidade){
		AutowireHelper.autowire(this);	
		registroLog.registrarLog((E) entidade, Acoes.DELETAR);
	}
	
}
