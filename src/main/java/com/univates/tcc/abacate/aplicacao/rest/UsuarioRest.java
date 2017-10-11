
package com.univates.tcc.abacate.aplicacao.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.univates.tcc.abacate.aplicacao.rest.autorizacao.RequerAutenticacao;
import com.univates.tcc.abacate.aplicacao.rest.permissao.RequerPermissao;
import com.univates.tcc.abacate.aplicacao.rest.permissao.TipoDePermissao;
import com.univates.tcc.abacate.dominio.entidades.Permissao;
import com.univates.tcc.abacate.dominio.entidades.Usuario;
import com.univates.tcc.abacate.dominio.servicos.PermissaoServico;
import com.univates.tcc.abacate.dominio.servicos.UsuarioServico;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UsuarioRest extends CrudAbstratoRest<Usuario, Integer> {

	private UsuarioServico usuarioServico;
	
	private PermissaoServico permissaoServico;

	@Autowired
	public UsuarioRest(UsuarioServico servicoDeCrud, PermissaoServico permissaoServico) {
		super(servicoDeCrud);
		this.usuarioServico = servicoDeCrud;
		this.permissaoServico = permissaoServico;
	}
	
	@RequestMapping(value="/autenticar", method=RequestMethod.POST) 
	public final ResponseEntity<Usuario> autenticar(@RequestBody Usuario usuario){
		usuario = usuarioServico.autenticar(usuario);		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}	
	
	@RequestMapping(value="/resetarSenha", method=RequestMethod.PATCH) 
	public final ResponseEntity<Usuario> resetarSenha(@RequestBody Usuario usuario){
		usuario = usuarioServico.resetarSenha(usuario);		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}	
	
	@RequerAutenticacao
	@RequerPermissao(tipoDePermissao = TipoDePermissao.CONSULTAR)
	@RequestMapping(method=RequestMethod.GET, value = "permissoesDoUsuario/{id}")
	public final ResponseEntity<Collection<Permissao>> buscarPermissoesDoUsuario(@PathVariable("id") Integer idDoUsuario){
		return new ResponseEntity<Collection<Permissao>>(permissaoServico.permissoesDoUsuario(idDoUsuario), HttpStatus.OK);
	}
	
	@RequestMapping(value="/salvarPermissoes", method=RequestMethod.PATCH) 
	public final ResponseEntity<Collection<Permissao>> salvarPermissoes(@RequestBody Collection<Permissao> permissoes){
		permissaoServico.salvarListaDePermissoes(permissoes);
		return new ResponseEntity<Collection<Permissao>>(HttpStatus.OK);
	}		
}
