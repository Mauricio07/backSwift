package com.swift;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwiftApplication {

	private static final Logger log = LoggerFactory.getLogger(SwiftApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SwiftApplication.class, args);
		
	}

}
