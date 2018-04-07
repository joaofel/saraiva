package com.joao.saraiva.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.joao.saraiva.model.Livro;
import com.joao.saraiva.model.LivroResumo;


@Component 
public class LivrosClient implements CommandLineRunner{
	
	public static void livrosClient() {
		RestTemplate restTemplate = new RestTemplate();
		String URI_BASE = "https://api.saraiva.com.br/sc/produto/pdp/9731880/0/0/1/";
		
		LivroResumo livroResumo = restTemplate.getForObject(URI_BASE, LivroResumo.class);
		
		Livro livro = new Livro();
		livro.setSku(livroResumo.getSku());
		livro.setBrand(livroResumo.getBrand());
		livro.setPrice(livroResumo.getPrice().getBestPrice().getValue());
		
		System.out.println("SKU: " + livro.getSku());
		System.out.println("Brand: " + livro.getBrand());
		System.out.println("Price: " + livro.getPrice());

	}

	@Override
	public void run(String... args) throws Exception {
		livrosClient();	
	}
	

}
