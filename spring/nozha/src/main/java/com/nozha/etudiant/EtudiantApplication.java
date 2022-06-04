package com.nozha.etudiant;

import java.util.Date;

import com.nozha.etudiant.entities.Etudiant;
import com.nozha.etudiant.service.EtudiantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EtudiantApplication implements CommandLineRunner {

	@Autowired
	EtudiantService enseignantService;
	
	public static void main(String[] args) {
		SpringApplication.run(EtudiantApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	
}
}
