package com.simplilearn.sportyshoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.simplilearn.sportyshoes.controller","com.simplilearn.sportyshoes.vo"
		,"com.simplilearn.sportyshoes.service","com.simplilearn.sportyshoes.repository"})
//@EnableJpaRepositories(basePackages = {"com.simplilearn.sportyshoes.repository"})
//@EntityScan(basePackages = {"com.simplilearn.sportyshoes.vo"})
public class SportyshoesAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportyshoesAppApplication.class, args);
	}

}
