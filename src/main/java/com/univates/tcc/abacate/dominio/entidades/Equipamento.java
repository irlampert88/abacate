package com.univates.tcc.abacate.dominio.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "equipamentos")
public class Equipamento extends EntidadeAbstrata<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String descricao;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "marca_id", nullable = false)
	private Marca marca;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tipo_equipamento_id", nullable = false)
	private TipoEquipamento tipoDoEquipamento;
	
	@Column
	private String detalhes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public TipoEquipamento getTipoDoEquipamento() {
		return tipoDoEquipamento;
	}

	public void setTipoDoEquipamento(TipoEquipamento tipoDoEquipamento) {
		this.tipoDoEquipamento = tipoDoEquipamento;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

}
