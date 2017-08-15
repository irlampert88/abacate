package com.univates.tcc.abacate.integration.repositories.converters;

import javax.persistence.Converter;

import com.univates.tcc.abacate.domain.aggregates.Families;

@Converter(autoApply = true)
public class FamiliesConverter 
	extends AbstractEnumConverter<Families, String> {

	private static final long serialVersionUID = 1L;

	@Override
	public String convertToDatabaseColumn(Families attribute) {
		return toDatabaseColumn(attribute);
	}

	@Override
	public Families convertToEntityAttribute(String dbData) {
		return toEntityAttribute(Families.class, dbData);
	}

}
