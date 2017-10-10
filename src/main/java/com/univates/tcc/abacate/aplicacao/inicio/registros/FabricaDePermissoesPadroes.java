package com.univates.tcc.abacate.aplicacao.inicio.registros;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univates.tcc.abacate.dominio.entidades.Marca;
import com.univates.tcc.abacate.dominio.entidades.Permissao;
import com.univates.tcc.abacate.dominio.entidades.Usuario;
import com.univates.tcc.abacate.dominio.servicos.PermissaoServico;
import com.univates.tcc.abacate.dominio.servicos.UsuarioServico;
import com.univates.tcc.abacate.dominio.utilitarios.NomeDaTabela;

@Component
public class FabricaDePermissoesPadroes 
	implements FabricaDeRegistroPadrao {

	@Autowired
	private PermissaoServico permissaoServico;
	
	@Autowired 
	private UsuarioServico usuarioServico;
	
	@Override
	public void criarRegistrosPadroes() {
		if (usuarioServico.buscarTodos().size() == 1) {
			Collection<Permissao> permissoes = permissaoServico.permissoesDoUsuario(1);
			
			if(!permissoes.isEmpty()) {
				alterarPermissaoPara(permissoes, NomeDaTabela.daClasse(Permissao.class));
				alterarPermissaoPara(permissoes, NomeDaTabela.daClasse(Marca.class));
				alterarPermissaoPara(permissoes, NomeDaTabela.daClasse(Usuario.class));
			}
		}
	}

	private void alterarPermissaoPara(Collection<Permissao> permissoes, String nomeDaTabela) {
		for (Permissao permissao : permissoes) {
			if (nomeDaTabela.equals(permissao.getTabela())) {
				permissao.setConsultar(true);
				permissao.setAlterar(true);
				permissao.setDeletar(true);
				permissao.setInserir(true);
				permissaoServico.alterar(permissao);
			}
		}
	}

}
