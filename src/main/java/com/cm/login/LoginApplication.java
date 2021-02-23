package com.cm.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.cm.login.controller")
@ComponentScan(basePackages = "com.cm.login.service")
@ComponentScan(basePackages = "com.cm.login.configuration")
@EntityScan(basePackages = "com.cm.login.model")
@EnableJpaRepositories(basePackages = "com.cm.login.repository")

@SpringBootApplication
public class LoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}

}
