package com.joao.saraiva.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joao.saraiva.model.Livro;
import com.joao.saraiva.repository.query.LivroRepositoryQuery;

public interface LivroRepository extends JpaRepository<Livro, Long>, LivroRepositoryQuery{

}
