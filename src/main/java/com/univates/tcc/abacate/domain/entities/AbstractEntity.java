package com.univates.tcc.abacate.domain.entities;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.OptimisticLock;

import com.univates.tcc.abacate.domain.aggregates.Families;
import com.univates.tcc.abacate.domain.aggregates.Identifiable;
import com.univates.tcc.abacate.domain.helpers.CloneEntity;
import com.univates.tcc.abacate.domain.helpers.EntityComparator;
import com.univates.tcc.abacate.domain.helpers.EntityEquals;
import com.univates.tcc.abacate.domain.helpers.HashCodeGenerator;
import com.univates.tcc.abacate.domain.helpers.ToStringGenerator;

@MappedSuperclass
public abstract class AbstractEntity<ID extends Serializable> 
	implements Identifiable<ID>, Serializable, Cloneable, Comparable<AbstractEntity<ID>> {
	
	private static final long serialVersionUID = 1L;

	public abstract Families family();
	
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
	public final int compareTo(AbstractEntity<ID> otherEntity) {
		return EntityComparator.compare(this, otherEntity);
	}
	
	@Override
	public final Object clone() {
		return CloneEntity.makeClone(this);
	}
	
	@Override
	public final int hashCode() {
		return HashCodeGenerator.generate(this);
	}
	
	@Override
	public final String toString() {
		return ToStringGenerator.generate(this);
	}
	
	@Override
	public final boolean equals(Object other) {
		return EntityEquals.isEquals(this, other);
	}
	
}
