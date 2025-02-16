package com.github.nicholastimothycoffman.AustinAutoAdjust.trafficdata.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.test.context.support.WithMockUser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.time.LocalDateTime;

import com.github.nicholastimothycoffman.AustinAutoAdjust.AustinAutoAdjustApplication;
import com.github.nicholastimothycoffman.AustinAutoAdjust.trafficdata.model.TrafficData; // Ensure this matches the package of your TrafficData class

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = AustinAutoAdjustApplication.class)
@AutoConfigureMockMvc
public class TrafficDataControllerTests {

	@Autowired
    	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

 	@Configuration
    	static class TestConfig {
        	@Bean
        	public ObjectMapper objectMapper() {
            		ObjectMapper mapper = new ObjectMapper();
            		mapper.registerModule(new JavaTimeModule());
            		return mapper;
        	}
    	}

	@TestConfiguration
	static class TestSecurityConfig {
    		@Bean
    		public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        		http
            			.csrf(csrf -> csrf.disable())  // Disable CSRF for tests
            			.authorizeHttpRequests(auth -> auth
                			.requestMatchers("/traffic-data").permitAll()
                			.anyRequest().authenticated())  // Authenticate all other requests
            			.formLogin(form -> form.disable()) // Disable form login (optional)
            			.httpBasic(httpBasic -> httpBasic.disable());  // Avoid deprecated method

        		return http.build();
    		}
	}



	@Test
	public void logObjectMapperModules() {
    		System.out.println("Registered Modules: " + objectMapper.getRegisteredModuleIds());
	}

	@Test
	@WithMockUser(username = "testuser", roles = {"USER"})  // Ensure role matches SecurityConfig
	public void testCreateTrafficData() throws Exception {
    		TrafficData trafficData = new TrafficData();
    		trafficData.setTimestamp(LocalDateTime.now());
    		trafficData.setLocation("Downtown Austin");
    		trafficData.setSpeed(50.0);
    		trafficData.setTrafficVolume(200);

    		String json = objectMapper.writeValueAsString(trafficData);  // Use injected ObjectMapper

    		mockMvc.perform(post("/traffic-data")
            		.contentType(MediaType.APPLICATION_JSON)
            		.content(json))
            		.andExpect(status().isOk())  // Expect 200 OK if authentication is correct
            		.andExpect(jsonPath("$.id").exists());
	}

}

