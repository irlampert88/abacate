package com.univates.tcc.abacate.dominio.entidades;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.OptimisticLock;

import com.univates.tcc.abacate.dominio.agregadores.Identificado;
import com.univates.tcc.abacate.dominio.utilitarios.ClonadorDeEntidades;
import com.univates.tcc.abacate.dominio.utilitarios.ComparadorDeEntidades;
import com.univates.tcc.abacate.dominio.utilitarios.GeradorDeEqualsParaEntidades;
import com.univates.tcc.abacate.dominio.utilitarios.GeradorDeHashcodeParaEntidades;
import com.univates.tcc.abacate.dominio.utilitarios.GeradorDeToStringParaEntidades;

@MappedSuperclass
public abstract class EntidadeAbstrata<ID extends Serializable> 
	implements Identificado<ID>, Serializable, Cloneable, Comparable<EntidadeAbstrata<ID>> {
	
	private static final long serialVersionUID = 1L;
	
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
	
	@Override
	public final int compareTo(EntidadeAbstrata<ID> otherEntity) {
		return ComparadorDeEntidades.comparar(this, otherEntity);
	}
	
	@Override
	public final Object clone() {
		return ClonadorDeEntidades.clonar(this);
	}
	
	@Override
	public final int hashCode() {
		return GeradorDeHashcodeParaEntidades.gerar(this);
	}
	
	@Override
	public final String toString() {
		return GeradorDeToStringParaEntidades.gerar(this);
	}
	
	@Override
	public final boolean equals(Object other) {
		return GeradorDeEqualsParaEntidades.verificaSeIgual(this, other);
	}
	
}
