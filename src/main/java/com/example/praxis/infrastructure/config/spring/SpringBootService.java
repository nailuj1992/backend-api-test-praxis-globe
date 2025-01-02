package com.example.praxis.infrastructure.config.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.example.praxis.infrastructure")
@EntityScan(basePackages = "com.example.praxis.domain")
public class SpringBootService {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootService.class, args);
	}

}
