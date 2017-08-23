package com.univates.tcc.abacate.dominio.agregadores;

import java.io.Serializable;
import java.util.stream.Stream;

public interface EnumAbstrato<UUID extends Serializable> {

	public UUID getUuid();
	public String getDescription();

	public static <ENUM extends Enum<ENUM> & EnumAbstrato<UUID>, UUID extends Serializable> ENUM porUuid(
			Class<ENUM> enumClass, UUID uuid) {

		return Stream.of(enumClass.getEnumConstants())
					 .filter(enumObject -> enumObject.getUuid().equals(uuid))
					 .findFirst()
					 .orElseThrow(() -> {return erroQuandoNaoEncontrado(enumClass, uuid);});
	}
	
	static <ENUM extends Enum<ENUM> & EnumAbstrato<UUID>, UUID extends Serializable> IllegalArgumentException erroQuandoNaoEncontrado(
			Class<ENUM> enumClass, UUID uuid) {
		
		String notFoundMessage = "Não foi possível localizar um Enum " + enumClass.getName() + " com o Uuid " + uuid.toString();
		return new IllegalArgumentException(notFoundMessage);
	}
}
