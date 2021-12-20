package com.springapps.springSecurityProject;

import com.springapps.springSecurityProject.entities.Role;
import com.springapps.springSecurityProject.entities.User;
import com.springapps.springSecurityProject.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityProjectApplication.class, args);
	}
	@Bean
	CommandLineRunner run(UserService userService){
		return  args -> {
			userService.saveRole(new Role(null,"first_role"));
			userService.saveRole(new Role(null,"second_role"));
			userService.saveRole(new Role(null,"third_role"));

			userService.saveUser(new User(null,"Ahmet Can","Akdaş","acanakdas","acanakdas",new ArrayList<>()));
			userService.saveUser(new User(null,"Acan","Aktaş","acan","acan",new ArrayList<>()));

			userService.addRoleToUser("acanakdas","first_role");
			userService.addRoleToUser("acan","second_role");

		};

	}
}
