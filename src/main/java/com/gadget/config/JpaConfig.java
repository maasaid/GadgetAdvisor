package com.gadget.config;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableJpaAuditing
public class JpaConfig {
    // You can leave this class empty, as it only serves to enable JPA Auditing
}

