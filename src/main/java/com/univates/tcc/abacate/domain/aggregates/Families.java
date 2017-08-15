package com.univates.tcc.abacate.domain.aggregates;

import com.univates.tcc.abacate.domain.helpers.ToStringGenerator;

public enum Families
	implements AbstractEnum<String> {
	// App
	FOO("0001", "Foo", ""),
	
	// Domain
	PERSON("0102", "Pessoa", ""),
	;
	
	private final String uuid;
	private final String description;
	private final String image;
	
	private Families(String uuid, String description, String image) {
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
		return ToStringGenerator.generate(this);
	}
}
