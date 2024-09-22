package com.Project.SpringAngular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class SpringAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAngularApplication.class, args);
	}

		/*@GetMapping("/")
		public String login(){
		return "AUTHENTIFICATION SUCCESSFULLY";
		}

		@GetMapping("/")*/


}
