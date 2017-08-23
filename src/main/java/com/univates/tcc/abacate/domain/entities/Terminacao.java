package com.univates.tcc.abacate.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "terminacoes")
public class Terminacao extends AbstractEntity<Integer> {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String terminacao;

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTerminacao() {
		return terminacao;
	}
	
	public void setTerminacao(String terminacao) {
		this.terminacao = terminacao;
	}
	
}
