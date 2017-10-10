package com.univates.tcc.abacate.integracao.repositorios.impl.hibernate;

import java.util.Collection;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;
import com.univates.tcc.abacate.dominio.entidades.Usuario;
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
		Session session = entityManager.unwrap(Session.class);
		session.clear();

		Example example = Example.create(exampleEntity).enableLike(MatchMode.ANYWHERE).ignoreCase();
		Criteria criteria = session.createCriteria(exampleEntity.getClass()).add(example);

		return (Collection<E>) criteria.list();
	}

	@Override
	public <E extends EntidadeAbstrata<?>> Collection<E> buscarPeloExemploComPaginacao(E exampleEntity, Integer pagina, Integer quantidade, String atributoOrdenado, String ordem) {
		Session session = entityManager.unwrap(Session.class);
		session.clear();

		Example example = Example.create(exampleEntity).enableLike(MatchMode.ANYWHERE).ignoreCase();
		Criteria criteria = session.createCriteria(exampleEntity.getClass()).add(example);
		criteria.setMaxResults(quantidade);
		criteria.setFirstResult(pagina*quantidade);
		
		if (!StringUtils.isEmpty(atributoOrdenado) && !StringUtils.isEmpty(ordem))
			criteria.addOrder("asc".equals(ordem) ? Order.asc(atributoOrdenado) : Order.desc(atributoOrdenado));
		
		return (Collection<E>) criteria.list();
	}

}
