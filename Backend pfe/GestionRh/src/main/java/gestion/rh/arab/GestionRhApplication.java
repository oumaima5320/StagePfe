package gestion.rh.arab;

import org.springframework.boot.CommandLineRunner;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import gestion.rh.arab.Controller.RegisterRequest;
import gestion.rh.arab.Service.AuthenticationService;


import gestion.rh.arab.entities.Role;

@SpringBootApplication
public class GestionRhApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionRhApplication.class, args);
	}
	
	
	
	}
	
	
	

