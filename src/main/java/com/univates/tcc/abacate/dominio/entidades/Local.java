package com.univates.tcc.abacate.dominio.entidades;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.univates.tcc.abacate.integracao.repositorios.ouvintes.OuvinteRegistroDeLog;

@Entity
@Table(name = "locais")
@EntityListeners(OuvinteRegistroDeLog.class)
public class Local extends EntidadeAbstrata<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String local;
	
	@Column
	private Integer predio;
	
	@Column
	private Integer andar;
	
	@Column
	private String observacao;
	
	@JsonIgnore
	@Column
	private Blob mapa;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "responsavel_id", nullable = false)
	private Responsavel responsavel;

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Integer getPredio() {
		return predio;
	}

	public void setPredio(Integer predio) {
		this.predio = predio;
	}

	public Integer getAndar() {
		return andar;
	}

	public void setAndar(Integer andar) {
		this.andar = andar;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Blob getMapa() {
		return mapa;
	}

	public void setMapa(Blob mapa) {
		this.mapa = mapa;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}
	
}
