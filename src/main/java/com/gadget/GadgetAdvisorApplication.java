package com.gadget;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class GadgetAdvisorApplication {

	public static void main(String[] args) {
		SpringApplication.run(GadgetAdvisorApplication.class, args);
	}

}
