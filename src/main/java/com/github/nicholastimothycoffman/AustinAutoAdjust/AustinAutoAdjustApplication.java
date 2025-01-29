package com.github.nicholastimothycoffman.AustinAutoAdjust;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class AustinAutoAdjustApplication {

    	public static void main(String[] args) {
        	SpringApplication.run(AustinAutoAdjustApplication.class, args);
    	}

    	// Register the JavaTimeModule with ObjectMapper
    	@Bean
    	public ObjectMapper objectMapper() {
        	ObjectMapper mapper = new ObjectMapper();
        	mapper.registerModule(new JavaTimeModule());
        	return mapper;
    	}
}

