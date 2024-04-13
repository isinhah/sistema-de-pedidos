package com.dev.spring;

import com.dev.spring.domain.*;
import com.dev.spring.domain.enums.ClientType;
import com.dev.spring.repositories.*;
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

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private AddressRepository addressRepository;

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

		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));

		cat1.getProducts().addAll(Arrays.asList(p1, p3));
		cat2.getProducts().addAll(Arrays.asList(p2, p3));

		p1.getCategories().add(cat1);
		p2.getCategories().add(cat2);
		p3.getCategories().addAll(Arrays.asList(cat1, cat2));

		State s1 = new State(null, "Pernambuco");
		State s2 = new State(null, "Bahia");

		City c1 = new City(null, "Recife", s1);
		City c2 = new City(null, "Paulo Afonso", s2);

		stateRepository.saveAll(Arrays.asList(s1, s2));
		cityRepository.saveAll(Arrays.asList(c1, c2));

		Client cli1 = new Client(null, "Isabel", "isabel@gmail.com", "96454645", ClientType.INDIVIDUAL);
		cli1.getPhones().addAll(Arrays.asList("34256346", "90395450"));
		Client cli2 = new Client(null, "Contabilizei Contabilidade LTDA", "contabiliza@gmail.com", "53546446", ClientType.LEGALENTITY);
		cli1.getPhones().addAll(Arrays.asList("05678653", "12343564"));

		Address ad1 = new Address(null, "Rua Flores", "300", "Apto 303", "Jardim", "546464", cli1, c2);
		Address ad2 = new Address(null, "Rua Campo Grande", "402", "Prédio 505", "Socorro", "232345", cli2, c1);

		clientRepository.saveAll(Arrays.asList(cli1, cli2));
		addressRepository.saveAll(Arrays.asList(ad1, ad2));
	}
}
