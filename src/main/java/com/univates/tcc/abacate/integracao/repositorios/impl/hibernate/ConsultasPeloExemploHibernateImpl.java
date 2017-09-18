package com.univates.tcc.abacate.integracao.repositorios.impl.hibernate;

import java.util.Collection;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;
import com.univates.tcc.abacate.integracao.repositorios.agregadores.ConsultasPeloExemplo;

@Repository
@SuppressWarnings("all")
public class ConsultasPeloExemploHibernateImpl
	implements ConsultasPeloExemplo {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public <E extends EntidadeAbstrata<?>> E buscarUmPeloExemplo(E exampleEntity) {
		Collection<E> resultados = buscarPeloExemplo(exampleEntity);
		return resultados.isEmpty() ? null : resultados.stream().findFirst().get();
	}

	@Override
	public <E extends EntidadeAbstrata<?>> Collection<E> buscarPeloExemplo(E exampleEntity) {
		Example example = Example.create(exampleEntity).enableLike(MatchMode.ANYWHERE);
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(exampleEntity.getClass()).add(example);

		return (Collection<E>) criteria.list();
	}

}
