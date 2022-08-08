package com.alpha;

import java.util.Arrays;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.alpha.entity.ClientEntity;
import com.alpha.entity.ProductEntity;
import com.alpha.repository.ClientRepository;
import com.alpha.repository.ProductRepository;

@SpringBootApplication
public class AlphaMainApp {

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(AlphaMainApp.class, args);
	}
	
	
	//Populate Test Data
	@Bean
	public ApplicationRunner initializer(ProductRepository productRepository, ClientRepository clientRepository) {
		
		clientRepository.saveAll(Arrays.asList(
	    		ClientEntity.builder().id(UUID.randomUUID().toString()).name("Goole").build(),
	    		ClientEntity.builder().id(UUID.randomUUID().toString()).name("Microsoft").build(),
	    		ClientEntity.builder().id(UUID.randomUUID().toString()).name("Samsung").build(),
	    		ClientEntity.builder().id(UUID.randomUUID().toString()).name("Noika").build(),
	    		ClientEntity.builder().id(UUID.randomUUID().toString()).name("LG").build()
	    ));
	    
	    return args -> productRepository.saveAll(Arrays.asList(
	    		ProductEntity.builder().id(UUID.randomUUID().toString()).name("Phone").build(),
	    		ProductEntity.builder().id(UUID.randomUUID().toString()).name("MS Office").build(),
	    		ProductEntity.builder().id(UUID.randomUUID().toString()).name("Laptop").build(),
	    		ProductEntity.builder().id(UUID.randomUUID().toString()).name("Earphone").build(),
	    		ProductEntity.builder().id(UUID.randomUUID().toString()).name("Desktop").build()
	    ));
	}
}
