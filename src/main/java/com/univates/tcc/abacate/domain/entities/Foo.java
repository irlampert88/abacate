package com.univates.tcc.abacate.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.univates.tcc.abacate.domain.aggregates.Families;

@Entity
@Table(name = "tb_foo")
public final class Foo extends AbstractEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nick;
	@Column
	private Long document;

	public Foo() {
	}
	
	public Foo(String nick, Long document) {
		this.nick = nick;
		this.document = document;
	}

	@Override
	public final Families family() {
		return Families.FOO;
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Long getDocument() {
		return document;
	}

	public void setDocument(Long document) {
		this.document = document;
	}

}
