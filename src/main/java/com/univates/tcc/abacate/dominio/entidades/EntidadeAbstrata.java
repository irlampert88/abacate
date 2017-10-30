package com.univates.tcc.abacate.dominio.entidades;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.OptimisticLock;

import com.univates.tcc.abacate.dominio.agregadores.Identificado;

@MappedSuperclass
public abstract class EntidadeAbstrata<ID extends Serializable> 
	extends ObjetoAbstrato
		implements Identificado<ID> {
	
	private static final long serialVersionUID = 1L;
	
	public EntidadeAbstrata() {
	}
	
	/** 
	 * @see OptimisticLock
	 */
    private Long version;
    
    @Version
	protected final Long getVersion() {
		return version;
	}
	
	protected final void setVersion(Long version) {
		this.version = version;
	}
	
}
