package com.nozha.etudiant.service;

import java.util.List;

import com.nozha.etudiant.entities.Formation;
import com.nozha.etudiant.repos.FormationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class FormationServiceImpl implements FormationService {
	
	@Autowired
	private FormationRepository formationRepository;

	@Override
	public List<Formation> findAll() {
	
		return formationRepository.findAll();
		
	}

	@Override
	public Formation saveFormation(Formation e) {
		return formationRepository.save(e) ;
	}

	@Override
	public Formation updateFormation(Formation e) {
		return formationRepository.save(e);
	}

	@Override
	public void deleteFormation(Formation e) {
		formationRepository.delete(e);		
	}

	@Override
	public void deleteFormationById(Long id) {
		formationRepository.deleteById(id);		
	}

	@Override
	public Formation getFormation(Long id) {
		return formationRepository.findById(id).get();
	}

	

	@Override
	public Page<Formation> getAllFormationsParPage(int page, int size) {
		return formationRepository.findAll(PageRequest.of(page, size));
	}

}
