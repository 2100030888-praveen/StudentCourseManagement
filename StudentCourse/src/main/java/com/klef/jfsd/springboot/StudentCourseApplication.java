package com.klef.jfsd.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages =  "com.klef.jfsd.springboot.repository") // Adjust the package name

public class StudentCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentCourseApplication.class, args);
	}

}
