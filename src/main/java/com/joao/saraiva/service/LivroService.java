package com.joao.saraiva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joao.saraiva.model.Livro;
import com.joao.saraiva.repository.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;

	public Livro salvar(Livro livro) {
		return livroRepository.save(livro);
	}
	
}
