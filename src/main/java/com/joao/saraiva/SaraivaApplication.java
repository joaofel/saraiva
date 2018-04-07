package com.joao.saraiva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.joao.saraiva"})
@EnableJpaRepositories(basePackages = { "com.joao.saraiva.repository" }) 
public class SaraivaApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SaraivaApplication.class, args);
	}
}
