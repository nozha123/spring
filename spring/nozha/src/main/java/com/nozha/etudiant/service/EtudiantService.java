package com.nozha.etudiant.service;

import java.util.List;

import com.nozha.etudiant.entities.Etudiant;
import com.nozha.etudiant.entities.Formation;

import org.springframework.data.domain.Page;

public interface EtudiantService {
	
	Etudiant saveEtudiant(Etudiant e);
	Etudiant updateEtudiant(Etudiant e);
	void deleteEtudiant(Etudiant e);
	void deleteEtudiantById(Long id);
	Etudiant getEtudiant(Long id);
	List<Etudiant> getAllEtudiants();
	List<Etudiant> findByNomEtudiantContains(String nom);
	List<Etudiant> findByFormationIdFormation(Long id);
	Page<Etudiant> getAllEtudiantsParPage(int page, int size);

}
