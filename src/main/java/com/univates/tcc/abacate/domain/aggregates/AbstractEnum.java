package com.univates.tcc.abacate.domain.aggregates;

import java.io.Serializable;
import java.util.stream.Stream;

public interface AbstractEnum<UUID extends Serializable> {

	public UUID getUuid();
	public String getDescription();

	public static <ENUM extends Enum<ENUM> & AbstractEnum<UUID>, UUID extends Serializable> ENUM byUuid(
			Class<ENUM> enumClass, UUID uuid) {

		return Stream.of(enumClass.getEnumConstants())
					 .filter(enumObject -> enumObject.getUuid().equals(uuid))
					 .findFirst()
					 .orElseThrow(() -> {return exceptionWhenNotFound(enumClass, uuid);});
	}
	
	static <ENUM extends Enum<ENUM> & AbstractEnum<UUID>, UUID extends Serializable> IllegalArgumentException exceptionWhenNotFound(
			Class<ENUM> enumClass, UUID uuid) {
		
		String notFoundMessage = "Não foi possível localizar um Enum " + enumClass.getName() + " com o Uuid " + uuid.toString();
		return new IllegalArgumentException(notFoundMessage);
	}
}
