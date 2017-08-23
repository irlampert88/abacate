package com.univates.tcc.abacate.integracao.repositorios.conversores;

import java.io.Serializable;

import javax.persistence.AttributeConverter;

import com.univates.tcc.abacate.dominio.agregadores.EnumAbstrato;

public abstract class ConversorDeEnumAbstrato<ENUM extends Enum<ENUM> & EnumAbstrato<UUID>, UUID extends Serializable> 
	implements AttributeConverter<ENUM, UUID>, Serializable {

	private static final long serialVersionUID = 1L;

	protected final UUID toDatabaseColumn(ENUM enumObject) {
		return enumObject != null ? enumObject.getUuid() : null;
	}

	protected final ENUM toEntityAttribute(Class<ENUM> enumClass, UUID dbData) {
		return dbData == null ? null : EnumAbstrato.porUuid(enumClass, dbData);
	}

}
