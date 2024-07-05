package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args -> {
			Student leng = new Student("Leng", "Leng@gmail.com", LocalDate.of(1999, 8, 21));
			Student dara = new Student("dara", "dara@gmail.com", LocalDate.of(2004, 9, 23));
			repository.saveAll(
					List.of(leng, dara)
					);
		};
	}
}
