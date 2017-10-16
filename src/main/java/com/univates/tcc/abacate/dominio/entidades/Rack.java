package com.univates.tcc.abacate.dominio.entidades;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.univates.tcc.abacate.dominio.agregadores.Foto;
import com.univates.tcc.abacate.integracao.repositorios.ouvintes.OuvinteRegistroDeLog;

@Entity
@Table(name = "racks")
@EntityListeners(OuvinteRegistroDeLog.class)
public class Rack extends EntidadeAbstrata<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String identificacao;
	
	@Column
	private String observacoes;
	
	@Column
	private Integer ativo;
	
	@Column
	private Integer numeroU;
	
	@Column
	private Float altura;
	
	@Column
	private Float largura;
	
	@Column
	private Float profundidade;

	@Column(length = 64000)
	@Foto
	private String foto;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "local_id", nullable = false)
	private Local local;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "cabling_id", nullable = false)
	private Cabling cabling;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "terminacao_id", nullable = false)
	private Terminacao terminacao;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "tipo_rack_id", nullable = false)
	private TipoRack tipoRack;
	
	@OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinTable(name = "equipamentos_do_rack",
			   joinColumns = { @JoinColumn(name = "equipamento_id") },
			   inverseJoinColumns = { @JoinColumn(name = "rack_id") } )
	private Set<Equipamento> equipamentosDoRack;

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}

	public Integer getNumeroU() {
		return numeroU;
	}

	public void setNumeroU(Integer numeroU) {
		this.numeroU = numeroU;
	}

	public Float getAltura() {
		return altura;
	}

	public void setAltura(Float altura) {
		this.altura = altura;
	}

	public Float getLargura() {
		return largura;
	}

	public void setLargura(Float largura) {
		this.largura = largura;
	}

	public Float getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(Float profundidade) {
		this.profundidade = profundidade;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Cabling getCabling() {
		return cabling;
	}

	public void setCabling(Cabling cabling) {
		this.cabling = cabling;
	}

	public Terminacao getTerminacao() {
		return terminacao;
	}

	public void setTerminacao(Terminacao terminacao) {
		this.terminacao = terminacao;
	}

	public TipoRack getTipoRack() {
		return tipoRack;
	}

	public void setTipoRack(TipoRack tipoRack) {
		this.tipoRack = tipoRack;
	}
	
	public Set<Equipamento> getEquipamentosDoRack() {
		return equipamentosDoRack;
	}
	public void setEquipamentosDoRack(Set<Equipamento> equipamentosDoRack) {
		this.equipamentosDoRack = equipamentosDoRack;
	}
	
}
