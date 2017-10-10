package com.univates.tcc.abacate.dominio.repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.univates.tcc.abacate.dominio.entidades.Permissao;
import com.univates.tcc.abacate.integracao.repositorios.agregadores.RepositorioDeCrud;

@Repository
@Transactional
public interface PermissaoRepositorio 
	extends RepositorioDeCrud<Permissao, Integer> {

	@Query(nativeQuery = true, 
			value = "select * from permissoes where usuario_id = :usuarioId and tabela = :nomeDaTabela")
	Permissao buscarPermissaoDoUsuarioNaTabela(@Param("usuarioId") Integer usuarioId, @Param("nomeDaTabela") String nomeDaTabela);

	@Query(nativeQuery = true, 
			value = "select * from permissoes where usuario_id = :usuarioId")
	Collection<Permissao> buscarPermissoesDoUsuario(@Param("usuarioId") Integer idDoUsuario);

}
