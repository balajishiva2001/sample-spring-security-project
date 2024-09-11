package com.samplespringsecurityproject.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleSpringSecurityProjectApplication {
	/*
	 * Rest:
	 * StateLess: disable csrf token
	 * StateFull: maintain session
	 */
	public static void main(String[] args) {
		SpringApplication.run(SampleSpringSecurityProjectApplication.class, args);
	}

}
