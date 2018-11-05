package com.validus.springboot.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootRestValidusApp extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestValidusApp.class, args);
	}
}
