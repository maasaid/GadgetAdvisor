package com.gadget.tech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF (not recommended for production, unless you're using JWT or API tokens)
                .csrf(AbstractHttpConfigurer::disable);

                /* Authorization for HTTP requests
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/GadgetAdvisor/**").permitAll() // Public endpoints
                        .anyRequest().authenticated() // All other endpoints require authentication
                );

                 */
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
