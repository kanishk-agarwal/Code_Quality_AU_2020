package com.pantry_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan("com.pantry_management*")
@EnableWebMvc
public class PantryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PantryManagementApplication.class, args);
	}

}
