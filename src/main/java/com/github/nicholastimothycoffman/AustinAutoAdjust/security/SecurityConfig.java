package com.github.nicholastimothycoffman.AustinAutoAdjust.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Security configuration class for handling authentication and authorization.
 * This class sets up security filter chains and manages user authentication.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	/**
	 * Configures HTTP security settings for the application.
	 * 
	 * @param http the HttpSecurity object used to configure security settings.
	 * @return A SecurityFilterChain defining security rules for API access.
	 * @throws Exception If an error occurs while configuring security.
	 */
    	@Bean
    	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        	http
            		.csrf(csrf -> csrf.disable())  // Disable CSRF for API access
            		.authorizeHttpRequests(auth -> auth
                		.requestMatchers(HttpMethod.POST, "/traffic-data").hasRole("USER")  // Ensure correct role
                		.requestMatchers(HttpMethod.GET, "/traffic-data/**").hasRole("USER") // Ensure correct role
                		.anyRequest().authenticated()
            		)
            		.httpBasic(Customizer.withDefaults());  // Enable basic authentication

        	return http.build();
    	}

	/**
 	 * Creates an in-memory user for testing authentication.
	 * 
	 * @return An InMemoryUserDetailsManager with a test user.
	 */
    	@Bean
    	public InMemoryUserDetailsManager userDetailsService() {
        	UserDetails user = User.withUsername("user")
            		.password("{noop}password")  // `{noop}` disables password encoding for testing
            		.roles("USER")  // Assigns the "USER" role
            		.build();
        	return new InMemoryUserDetailsManager(user);
    	}
}

