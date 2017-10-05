package com.univates.tcc.abacate.dominio.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.univates.tcc.abacate.dominio.entidades.Usuario;
import com.univates.tcc.abacate.integracao.repositorios.agregadores.RepositorioDeCrud;

@Repository
@Transactional
public interface UsuarioRepositorio 
	extends RepositorioDeCrud<Usuario, Integer> {

	@Query(nativeQuery = true,
		   value = " SELECT * FROM usuarios u " +
			       " WHERE u.usuario = :usuario " +
			       " AND u.senha = :senha " +
			       " AND u.ativo = 1 ")
	public Usuario procuraUsuarioParaAutenticar(@Param("usuario") String usuario, @Param("senha") String senha);

	@Query(nativeQuery = true,
			   value = " SELECT * FROM usuarios u " +
				       " WHERE u.usuario = :usuario " +
				       " AND u.email = :email" +
				       " AND u.ativo = 1 ")
	public Usuario procuraUsuarioParaResetDeSenha(@Param("usuario") String usuario, @Param("email") String email);
}
