package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author vinod.nagulkar
 *
 */
@SpringBootApplication
@ComponentScan("com.example")
@EntityScan({"com.example.bean","com.example"})
@EnableJpaRepositories(basePackages = "com.example.repo")
public class SpringBootMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcApplication.class, args);
		System.out.println("Hello from springboot");
	}

}
