package com.example.aeroperu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication

@EnableJpaAuditing
@EntityScan(basePackages = { "com.esq.models" })
public class AeroperuApplication {

	public static void main(String[] args) {
		SpringApplication.run(AeroperuApplication.class, args);
	}
}
