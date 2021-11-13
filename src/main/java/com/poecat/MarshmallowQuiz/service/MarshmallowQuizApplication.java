package com.poecat.MarshmallowQuiz.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.poecat.MarshmallowQuiz.repo")
@SpringBootApplication
public class MarshmallowQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarshmallowQuizApplication.class, args);
	}

}
