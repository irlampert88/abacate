package com.univates.tcc.abacate.dominio.agregadores;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.web.bind.annotation.RequestParam;

import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;
import com.univates.tcc.abacate.dominio.entidades.ObjetoAbstrato;

@SuppressWarnings("all")
public class ObjetoParaImpressao
	extends ObjetoAbstrato
		implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntidadeAbstrata entidadeDeExemplo;
//	private String classeDaEntidade;
	private Collection<String> titulos;
	private Collection<String> atributos;
	private Integer pagina;
	private Integer quantidade;
	private String atributoOrdenado; 
	private String ordem;

	public ObjetoParaImpressao() {
	}
	
	public EntidadeAbstrata getEntidadeDeExemplo() {
		return entidadeDeExemplo;
	}

	public void setEntidadeDeExemplo(EntidadeAbstrata entidadeDeExemplo) {
		this.entidadeDeExemplo = entidadeDeExemplo;
	}

	public Collection<String> getAtributos() {
		return atributos;
	}

	public void setAtributos(Collection<String> atributos) {
		this.atributos = atributos;
	}
	
	public Collection<String> getTitulos() {
		return titulos;
	}
	
	public void setTitulos(Collection<String> titulos) {
		this.titulos = titulos;
	}

	public Integer getPagina() {
		return pagina;
	}

	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getAtributoOrdenado() {
		return atributoOrdenado;
	}

	public void setAtributoOrdenado(String atributoOrdenado) {
		this.atributoOrdenado = atributoOrdenado;
	}

	public String getOrdem() {
		return ordem;
	}

	public void setOrdem(String ordem) {
		this.ordem = ordem;
	}
	
//	public String getClasseDaEntidade() {
//		return classeDaEntidade;
//	}
	
//	public void setClasseDaEntidade(String classeDaEntidade) {
//		this.classeDaEntidade = classeDaEntidade;
//	}
	
}
