package com.joao.saraiva.repository.query;

import java.util.List;

import com.joao.saraiva.model.Livro;
import com.joao.saraiva.repository.filter.LivroFilter;


public interface LivroRepositoryQuery {

	public List<Livro> filtrar(LivroFilter livroFilter);
}
