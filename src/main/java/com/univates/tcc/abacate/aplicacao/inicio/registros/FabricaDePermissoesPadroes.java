package com.univates.tcc.abacate.aplicacao.inicio.registros;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univates.tcc.abacate.dominio.entidades.Marca;
import com.univates.tcc.abacate.dominio.entidades.Permissao;
import com.univates.tcc.abacate.dominio.entidades.Usuario;
import com.univates.tcc.abacate.dominio.servicos.UsuarioServico;
import com.univates.tcc.abacate.dominio.utilitarios.NomeDaTabela;

@Component
public class FabricaDePermissoesPadroes 
	implements FabricaDeRegistroPadrao {

	@Autowired
	private UsuarioServico usuarioServico;
	
	@Override
	public void criarRegistrosPadroes() {
		Collection<Usuario> todosUsuarios = usuarioServico.buscarTodos();
		if(todosUsuarios.size() == 1) {
			Usuario usuario = todosUsuarios.stream().findFirst().get();
			adicionaPermissaoPara(usuario, NomeDaTabela.daClasse(Permissao.class));
			adicionaPermissaoPara(usuario, NomeDaTabela.daClasse(Marca.class));
			adicionaPermissaoPara(usuario, NomeDaTabela.daClasse(Usuario.class));
			usuarioServico.alterar(usuario);
		}
	}

	private void adicionaPermissaoPara(Usuario usuario, String nomeDaTabela) {
		for (Permissao permissao : usuario.getPermissoes()) {
			if (nomeDaTabela.equals(permissao.getTabela())) {
				permissao.setConsultar(true);
				permissao.setAlterar(true);
				permissao.setDeletar(true);
				permissao.setInserir(true);
			}
		}
	}

}
