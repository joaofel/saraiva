package com.joao.saraiva.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.joao.saraiva.model.Livro;
import com.joao.saraiva.repository.LivroRepository;
import com.joao.saraiva.repository.filter.LivroFilter;
import com.joao.saraiva.service.LivroService;

@RestController
@RequestMapping("/book")
public class LivroResource {
	
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private LivroRepository livroRepository;
	
	@GetMapping
	public List<Livro> filtrar(LivroFilter livroFilter) {
		return livroRepository.filtrar(livroFilter);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Livro> findBookBySku(@PathVariable Long codigo) {
		Livro livro = livroRepository.findOne(codigo);
		return livro == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(livro);
	}
	
	@PostMapping
	public ResponseEntity<Livro> criar(@Valid @RequestBody Livro livro, HttpServletResponse httpServletResponse) {
		Livro livroSalvo = livroService.salvar(livro);
		return ResponseEntity.status(HttpStatus.CREATED).body(livroSalvo);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		livroRepository.delete(codigo);
	}

}
