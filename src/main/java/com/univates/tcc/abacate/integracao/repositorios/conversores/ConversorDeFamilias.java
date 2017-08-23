package com.univates.tcc.abacate.integracao.repositorios.conversores;

import javax.persistence.Converter;

import com.univates.tcc.abacate.dominio.agregadores.Familias;

@Converter(autoApply = true)
public class ConversorDeFamilias 
	extends ConversorDeEnumAbstrato<Familias, String> {

	private static final long serialVersionUID = 1L;

	@Override
	public String convertToDatabaseColumn(Familias attribute) {
		return toDatabaseColumn(attribute);
	}

	@Override
	public Familias convertToEntityAttribute(String dbData) {
		return toEntityAttribute(Familias.class, dbData);
	}

}
