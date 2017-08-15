package com.univates.tcc.abacate.integration.repositories.converters;

import java.io.Serializable;

import javax.persistence.AttributeConverter;

import com.univates.tcc.abacate.domain.aggregates.AbstractEnum;

public abstract class AbstractEnumConverter<ENUM extends Enum<ENUM> & AbstractEnum<UUID>, UUID extends Serializable> 
	implements AttributeConverter<ENUM, UUID>, Serializable {

	private static final long serialVersionUID = 1L;

	protected final UUID toDatabaseColumn(ENUM enumObject) {
		return enumObject != null ? enumObject.getUuid() : null;
	}

	protected final ENUM toEntityAttribute(Class<ENUM> enumClass, UUID dbData) {
		return dbData == null ? null : AbstractEnum.byUuid(enumClass, dbData);
	}

}
