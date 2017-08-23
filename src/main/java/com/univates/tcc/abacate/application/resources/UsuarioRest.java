package com.univates.tcc.abacate.application.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univates.tcc.abacate.domain.entities.Usuario;
import com.univates.tcc.abacate.domain.repositories.UsuarioRepositorio;

@RestController
@RequestMapping("/usuarios")
public class UsuarioRest extends AbstractCrudResource<Usuario, Integer> {

	@Autowired
	public UsuarioRest(UsuarioRepositorio repositorio) {
		super(repositorio);
	}
	
}
