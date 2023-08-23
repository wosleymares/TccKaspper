package com.tcckaspper.banco;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;


@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(
						title = "BD_Locação",
						description = "API para inserir anuncíos e gerenciar locação",
						version = "1.0.0"))

@EnableScheduling
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class TcckaspperApplication {

	public static void main(String[] args) {
		SpringApplication.run(TcckaspperApplication.class, args);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;

	}

}
