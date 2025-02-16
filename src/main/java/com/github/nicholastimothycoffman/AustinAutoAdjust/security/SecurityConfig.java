package com.github.nicholastimothycoffman.AustinAutoAdjust.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    	@Bean
    	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        	http
            		.csrf(csrf -> csrf.disable())  // Disable CSRF for simplicity
            		.authorizeHttpRequests(auth -> auth
                		.requestMatchers("/traffic-data").hasRole("USER")  // Allow USER role
                		.anyRequest().authenticated())  // Require authentication for other endpoints
            		.httpBasic();  // Enable basic authentication for debugging

        	return http.build();
    	}
}

