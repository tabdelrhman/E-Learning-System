package com.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class E_learningStarter {

	public static void main(String[] args) {
		SpringApplication.run(E_learningStarter.class, args);
	}
}
