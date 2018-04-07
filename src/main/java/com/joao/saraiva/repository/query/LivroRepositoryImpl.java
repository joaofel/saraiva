package com.joao.saraiva.repository.query;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.joao.saraiva.model.Livro;
import com.joao.saraiva.repository.filter.LivroFilter;

public class LivroRepositoryImpl implements LivroRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Livro> filtrar(LivroFilter livroFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Livro> criteria = builder.createQuery(Livro.class);
		Root<Livro> root = criteria.from(Livro.class);
		
		Predicate[] predicates = criarRestricoes(livroFilter, builder, root);	
		criteria.where(predicates);
		
		TypedQuery<Livro> query = manager.createQuery(criteria);
		adicionarRestricoesPaginacao(query, livroFilter);
		
		return query.getResultList();
	}
	
	private Predicate[] criarRestricoes(LivroFilter livroFilter, CriteriaBuilder builder,
			Root<Livro> root) {
		
		List<Predicate> predicates = new ArrayList<>();
		
		System.out.println(livroFilter.getPrice());
		if (livroFilter.getPrice() != 0f) {
			predicates.add(builder.lessThanOrEqualTo(root.get("price"), livroFilter.getPrice()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private void adicionarRestricoesPaginacao(TypedQuery<?> query, LivroFilter livroFilter) {
		
		if (livroFilter.getLimit() != 0) {
			query.setMaxResults(livroFilter.getLimit());
		}	
	}
}
