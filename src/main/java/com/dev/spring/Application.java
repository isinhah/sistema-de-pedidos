package com.dev.spring;

import com.dev.spring.domain.Category;
import com.dev.spring.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Instanciacao dos objetos toda vez que o programa rodar
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
	}
}
