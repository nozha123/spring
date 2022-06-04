package com.nozha.etudiant.repos;

import java.util.List;

import com.nozha.etudiant.entities.Etudiant;


import org.springframework.data.jpa.repository.JpaRepository;

//les methodes prédefinie

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	
	List<Etudiant> findByNomEtudiantContains(String nom);
	
	List<Etudiant> findByFormationIdFormation(Long id);

	
	
	
}