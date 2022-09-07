package com.example.laptopsrestdatajpa;

import com.example.laptopsrestdatajpa.entities.Laptop;
import com.example.laptopsrestdatajpa.repositories.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CristinaSanchezGutierrezSesiones456Ejercicios123SpringApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CristinaSanchezGutierrezSesiones456Ejercicios123SpringApplication.class, args);
		context.getBean(LaptopRepository.class);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		Laptop laptop1 = new Laptop(null, "Asus", "55xc0", 249.99, 16, false);
		Laptop laptop2 = new Laptop(null, "DELL", "iX97", 450.00,32, true);
		repository.save(laptop1);
		repository.save(laptop2);

		System.out.println(repository.findAll().size());
		System.out.println(repository.findAll().toString());

	}

}
