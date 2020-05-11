package com.initech.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class LmsApp {

	public static void main(String[] args) {
		SpringApplication.run(LmsApp.class, args);
	}
}
