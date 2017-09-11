package com.univates.tcc.abacate.dominio.entidades;

import java.io.File;

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

import com.univates.tcc.abacate.integracao.repositorios.ouvintes.OuvinteRegistroDeLog;

@Entity
@Table(name = "pontos")
@EntityListeners(OuvinteRegistroDeLog.class)
public class Ponto extends EntidadeAbstrata<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String codPonto;

	@Column
	private Integer sala;
	
	@Column
	private Float certificacao;
	
	@Column
	private Float comprimento;
	
	@Column
	private Integer portaRamal;
	
	@Column
	private String observacoes;
	
	@Column
	private Integer mapaX;
	
	@Column
	private Integer mapaY;
	
	@Column(length = 4000)
	private File foto;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "tipo_servico_id", nullable = false)
	private TipoServico tipoServico;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "situacao_id", nullable = false)
	private Situacao situacao;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "local_id", nullable = false)
	private Local local;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "rack_id", nullable = false)
	private Rack rack;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "equipamento_id", nullable = false)
	private Equipamento equipamento;
	
	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodPonto() {
		return codPonto;
	}

	public void setCodPonto(String codPonto) {
		this.codPonto = codPonto;
	}

	public Integer getSala() {
		return sala;
	}

	public void setSala(Integer sala) {
		this.sala = sala;
	}

	public Float getCertificacao() {
		return certificacao;
	}

	public void setCertificacao(Float certificacao) {
		this.certificacao = certificacao;
	}

	public Float getComprimento() {
		return comprimento;
	}

	public void setComprimento(Float comprimento) {
		this.comprimento = comprimento;
	}

	public Integer getPortaRamal() {
		return portaRamal;
	}

	public void setPortaRamal(Integer portaRamal) {
		this.portaRamal = portaRamal;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Integer getMapaX() {
		return mapaX;
	}

	public void setMapaX(Integer mapaX) {
		this.mapaX = mapaX;
	}

	public Integer getMapaY() {
		return mapaY;
	}

	public void setMapaY(Integer mapaY) {
		this.mapaY = mapaY;
	}

	public File getFoto() {
		return foto;
	}

	public void setFoto(File foto) {
		this.foto = foto;
	}

	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Rack getRack() {
		return rack;
	}

	public void setRack(Rack rack) {
		this.rack = rack;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	
}
