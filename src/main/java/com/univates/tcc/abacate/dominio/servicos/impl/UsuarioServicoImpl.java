package com.univates.tcc.abacate.dominio.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.dominio.entidades.Usuario;
import com.univates.tcc.abacate.dominio.repositorios.UsuarioRepositorio;
import com.univates.tcc.abacate.dominio.servicos.UsuarioServico;

@Service
public final class UsuarioServicoImpl 
	extends ServicoDeCrudImpl<UsuarioRepositorio, Usuario, Integer>
		implements UsuarioServico {

	@Autowired
	public UsuarioServicoImpl(UsuarioRepositorio repositorio) {
		super(repositorio);
	}
}
