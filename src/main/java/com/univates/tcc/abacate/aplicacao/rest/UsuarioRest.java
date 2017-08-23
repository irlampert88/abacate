package com.univates.tcc.abacate.aplicacao.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univates.tcc.abacate.dominio.entidades.Usuario;
import com.univates.tcc.abacate.dominio.repositorios.UsuarioRepositorio;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin
public class UsuarioRest extends CrudAbstratoRest<Usuario, Integer> {

	@Autowired
	public UsuarioRest(UsuarioRepositorio repositorio) {
		super(repositorio);
	}
	
}
