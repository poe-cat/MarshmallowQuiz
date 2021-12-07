package com.poecat.quiz;

import com.poecat.quiz.repo.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepo.class)
public class MarshmallowQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarshmallowQuizApplication.class, args);
	}

}
