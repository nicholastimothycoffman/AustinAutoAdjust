package com.github.nicholastimothycoffman.AustinAutoAdjust;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The main entry point for the AustinAutoAdjust application.
 * This is a Spring Boot application that initializes and runs the backend services.
 */
@SpringBootApplication
public class AustinAutoAdjustApplication {

	/**
	 * The main method that starts the Spring Boot application.
	 *
	 * @param args Command-line arguments passed at runtime.
	 */
    	public static void main(String[] args) {
        	SpringApplication.run(AustinAutoAdjustApplication.class, args);
    	}

	/**
	 * Configures and provides a custom Jackson {@link ObjectMapper} bean.
	 * This bean ensures proper handling of Java 8 date/time types and
	 * disables writing dates as timestamps for JSON serialization.
	 *
	 * @return A configured {@link ObjectMapper} instance.
	 */
	@Bean
	public ObjectMapper objectMapper() {
    		ObjectMapper mapper = new ObjectMapper();
    		mapper.registerModule(new JavaTimeModule()); // Support for Java 8 date/time API
    		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // Store dates as ISO-8601 strings
    		return mapper;
	}

}

