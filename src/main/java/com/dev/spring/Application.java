package com.dev.spring;

import com.dev.spring.domain.Category;
import com.dev.spring.domain.Product;
import com.dev.spring.repositories.CategoryRepository;
import com.dev.spring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Instanciacao dos objetos toda vez que o programa rodar
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");

		Product p1 = new Product(null, "Computador", 2000.00);
		Product p2 = new Product(null, "Caneta", 25.00);
		Product p3 = new Product(null, "Impressora", 800.00);

		cat1.getProducts().addAll(Arrays.asList(p1, p3));
		cat2.getProducts().addAll(Arrays.asList(p2, p3));

		p1.getCategories().add(cat1);
		p2.getCategories().add(cat2);
		p3.getCategories().addAll(Arrays.asList(cat1, cat2));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
	}
}
