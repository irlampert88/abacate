package com.univates.tcc.abacate.dominio.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.univates.tcc.abacate.integracao.repositorios.ouvintes.OuvinteRegistroDeLog;

@Entity
@Table(name = "cabling")
@EntityListeners(OuvinteRegistroDeLog.class)
public class Cabling extends EntidadeAbstrata<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String cabling;
	
	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCabling() {
		return cabling;
	}
	
	public void setCabling(String cabling) {
		this.cabling = cabling;
	}

}
