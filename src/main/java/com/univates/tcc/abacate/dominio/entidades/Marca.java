package com.univates.tcc.abacate.dominio.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marcas")
public class Marca extends EntidadeAbstrata<Integer> {

	private static final long serialVersionUID = -8772150325707462263L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String descricao;

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}