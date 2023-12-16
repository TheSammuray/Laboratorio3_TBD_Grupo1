package com.TBD.SistemaVoluntarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SistemaVoluntariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaVoluntariosApplication.class, args);
	}
}
