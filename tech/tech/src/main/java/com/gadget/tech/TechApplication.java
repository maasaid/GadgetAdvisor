package com.gadget.tech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication

public class TechApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechApplication.class, args);
	}

}
