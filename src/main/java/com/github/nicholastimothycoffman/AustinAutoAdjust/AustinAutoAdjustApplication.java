package com.github.nicholastimothycoffman.AustinAutoAdjust;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class AustinAutoAdjustApplication {

    	public static void main(String[] args) {
        	SpringApplication.run(AustinAutoAdjustApplication.class, args);
    	}

	@Bean
	public ObjectMapper objectMapper() {
    		ObjectMapper mapper = new ObjectMapper();
    		mapper.registerModule(new JavaTimeModule());
    		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    		return mapper;
	}

}

