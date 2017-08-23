package com.univates.tcc.abacate.dominio.agregadores;

import com.univates.tcc.abacate.dominio.utilitarios.GeradorDeToStringParaEntidades;

public enum Familias
	implements EnumAbstrato<String> {
	// App
	FOO("0001", "Foo", ""),
	
	// Domain
	USUARIO("0101", "Usuario", ""),
	;
	
	private final String uuid;
	private final String description;
	private final String image;
	
	private Familias(String uuid, String description, String image) {
		this.uuid = uuid;
		this.description = description;
		this.image = image;
	}
	
	@Override
	public final String getUuid() {
		return uuid;
	}
	
	@Override
	public final String getDescription() {
		return description;
	}
	
	public final String getImage() {
		return image;
	}
	
	@Override
	public final String toString() {
		return GeradorDeToStringParaEntidades.gerar(this);
	}
}
