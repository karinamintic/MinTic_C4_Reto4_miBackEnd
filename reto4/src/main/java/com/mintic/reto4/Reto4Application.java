package com.mintic.reto4;

import com.mintic.reto4.repository.crud.CosmeticsCrudRepository;
import com.mintic.reto4.repository.crud.OrderCrudRepository;
import com.mintic.reto4.repository.crud.UserCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class Reto4Application implements CommandLineRunner{

	@Autowired
    private OrderCrudRepository orderCrudRepository;
    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private CosmeticsCrudRepository cosmeticsCrudRepository;

	public static void main(String[] args) {
		SpringApplication.run(Reto4Application.class, args);
	}

	@Override
    public void run(String... args) throws Exception {
        cosmeticsCrudRepository.deleteAll();
        userCrudRepository.deleteAll();
        orderCrudRepository.deleteAll();
    }

}
