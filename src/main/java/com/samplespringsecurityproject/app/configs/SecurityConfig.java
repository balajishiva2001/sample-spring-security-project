package com.samplespringsecurityproject.app.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.samplespringsecurityproject.app.services.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService;

	@SuppressWarnings("deprecation")
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		// sample password encoder
		// daoAuthenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

		// Adding custom password encoder
		daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		return daoAuthenticationProvider;
	}

	// disable the csrf token to make it stateless
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		// disabling csrf token
		httpSecurity.csrf(customizer -> customizer.disable());
		
		//permit the "/addUser" without authentication
		// all requests to the server need authentication/login
		httpSecurity.authorizeHttpRequests(
				request -> request.requestMatchers("/addUser").permitAll().anyRequest().authenticated());

		// default login form for your application managed by spring
		// httpSecurity.formLogin(Customizer.withDefaults());

		// enter their credentials via a browser pop-up dialog, less secure than
		// form-login
		httpSecurity.httpBasic(Customizer.withDefaults());

		// each request is independent and doesn’t rely on storing session data.
		// users need to send their login details (like a token) every time they make a
		// request. every request we get new session id
		httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		return httpSecurity.build();
	}

	/*
	 * //Below method with @Bean is becomes invalid when we use the db based
	 * UserServiceDetails //By Default security look UserDetailsService, now we can
	 * add the multiple users as below
	 * 
	 * @SuppressWarnings("deprecation")
	 * 
	 * @Bean public UserDetailsService userDetailsService() {
	 * 
	 * UserDetails userDetails1 =
	 * User.withDefaultPasswordEncoder().username("admin").password("admin").roles(
	 * "ADMIN").build(); UserDetails userDetails2 =
	 * User.withDefaultPasswordEncoder().username("test").password("test").roles(
	 * "USER").build();
	 * 
	 * return new InMemoryUserDetailsManager(userDetails1, userDetails2); }
	 */
}
