package com.univates.tcc.abacate.aplicacao.inicio.registros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univates.tcc.abacate.dominio.entidades.Permissao;
import com.univates.tcc.abacate.dominio.entidades.Usuario;
import com.univates.tcc.abacate.dominio.servicos.PermissaoServico;
import com.univates.tcc.abacate.dominio.servicos.UsuarioServico;

@Component
public class FabricaDePermissoesPadroes 
	implements FabricaDeRegistroPadrao {

	@Autowired 
	private PermissaoServico servico;
	
	@Autowired
	private UsuarioServico usuarioServico;

	@Override
	public void criarRegistrosPadroes() {
		if (servico.buscarTodos().isEmpty()) {
			
			Usuario usuario = usuarioServico.buscarTodos().stream().findFirst().get();

			Permissao registro = new Permissao();
			registro.setUsuario(usuario);
			registro.setTabela("marcas");
			registro.setConsultar(true);
			
			servico.inserir(registro);
		}
	}

}
