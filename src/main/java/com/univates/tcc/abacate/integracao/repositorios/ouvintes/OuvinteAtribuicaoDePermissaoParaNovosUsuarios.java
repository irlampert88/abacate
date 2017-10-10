package com.univates.tcc.abacate.integracao.repositorios.ouvintes;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

import org.springframework.beans.factory.annotation.Autowired;

import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;
import com.univates.tcc.abacate.dominio.entidades.Usuario;
import com.univates.tcc.abacate.dominio.servicos.PermissaoServico;
import com.univates.tcc.abacate.integracao.spring.AutowireHelper;

@SuppressWarnings("all")
public class OuvinteAtribuicaoDePermissaoParaNovosUsuarios {
	
	@Autowired
	private PermissaoServico servicoDePermissoes;
	
	@PostPersist
    public <E extends EntidadeAbstrata<?>> void antesDeInserir(Object entidade){
		AutowireHelper.autowire(this);
		servicoDePermissoes.atribuirTodasAsTabelasNasPermissoesDoUsuario((Usuario) entidade);
	}
	
}
