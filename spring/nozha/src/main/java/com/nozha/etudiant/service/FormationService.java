package com.nozha.etudiant.service;

import java.util.List;

import com.nozha.etudiant.entities.Formation;

import org.springframework.data.domain.Page;

public interface FormationService {
	List <Formation> findAll();
	
	Formation saveFormation(Formation e);
	Formation updateFormation(Formation e);
	void deleteFormation(Formation e);
	void deleteFormationById(Long id);
	Formation getFormation(Long id);
	Page<Formation> getAllFormationsParPage(int page, int size);

}
