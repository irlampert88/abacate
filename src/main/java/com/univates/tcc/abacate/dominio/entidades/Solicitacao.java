package com.univates.tcc.abacate.dominio.entidades;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.univates.tcc.abacate.integracao.repositorios.conversores.ConversorDeLocalDateTime;

@Entity
@Table(name = "solicitacoes")
public class Solicitacao extends EntidadeAbstrata<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	@Convert(converter = ConversorDeLocalDateTime.class)
	private LocalDateTime abertura;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "tipo_solicitacao_id", nullable = false)
	private TipoSolicitacao tipoSolicitacao;
	
	@Column
	@Convert(converter = ConversorDeLocalDateTime.class)
	private LocalDateTime fechamento;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "responsavel_fechamento_id", nullable = false)
	private Usuario responsavelFechamento;
	
	@Column
	private Integer fechado;

	@Column
	private String observacoes;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "ponto_id", nullable = false)
	private Ponto ponto;
	
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

	public LocalDateTime getAbertura() {
		return abertura;
	}

	public void setAbertura(LocalDateTime abertura) {
		this.abertura = abertura;
	}

	public TipoSolicitacao getTipoSolicitacao() {
		return tipoSolicitacao;
	}

	public void setTipoSolicitacao(TipoSolicitacao tipoSolicitacao) {
		this.tipoSolicitacao = tipoSolicitacao;
	}

	public LocalDateTime getFechamento() {
		return fechamento;
	}

	public void setFechamento(LocalDateTime fechamento) {
		this.fechamento = fechamento;
	}

	public Usuario getResponsavelFechamento() {
		return responsavelFechamento;
	}

	public void setResponsavelFechamento(Usuario responsavelFechamento) {
		this.responsavelFechamento = responsavelFechamento;
	}

	public Integer getFechado() {
		return fechado;
	}

	public void setFechado(Integer fechado) {
		this.fechado = fechado;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Ponto getPonto() {
		return ponto;
	}

	public void setPonto(Ponto ponto) {
		this.ponto = ponto;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}
	
}
