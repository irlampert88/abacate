
package com.univates.tcc.abacate.aplicacao.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.univates.tcc.abacate.dominio.entidades.Usuario;
import com.univates.tcc.abacate.dominio.servicos.UsuarioServico;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UsuarioRest extends CrudAbstratoRest<Usuario, Integer> {

	private UsuarioServico usuarioServico;

	@Autowired
	public UsuarioRest(UsuarioServico servicoDeCrud) {
		super(servicoDeCrud);
		usuarioServico = servicoDeCrud;
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
	
}
