package com.nozha.etudiant.service;

import java.util.List;

import com.nozha.etudiant.entities.Etudiant;
import com.nozha.etudiant.entities.Formation;
import com.nozha.etudiant.repos.EtudiantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class EtudiantServiceImpl implements EtudiantService{

	@Autowired
	EtudiantRepository etudiantRepository;
	
	@Override
	public Etudiant saveEtudiant(Etudiant e) {
	
		return etudiantRepository.save(e);
	}

	@Override
	public Etudiant updateEtudiant(Etudiant e) {
		return etudiantRepository.save(e);
	}

	@Override
	public void deleteEtudiant(Etudiant e) {
		etudiantRepository.delete(e);
	}

	@Override
	public void deleteEtudiantById(Long id) {
		etudiantRepository.deleteById(id);
	}

	@Override
	public Etudiant getEtudiant(Long id) {
		return etudiantRepository.findById(id).get();
	}

	@Override
	public List<Etudiant> getAllEtudiants() {
		return etudiantRepository.findAll();
	}

	

	@Override
	public List<Etudiant> findByNomEtudiantContains(String nom) {
		return etudiantRepository.findByNomEtudiantContains(nom);
	}

	
	@Override
	public List<Etudiant> findByFormationIdFormation(Long id) {
		return etudiantRepository.findByFormationIdFormation(id);
	}

	
	@Override
	public Page<Etudiant> getAllEtudiantsParPage(int page, int size) {
	return etudiantRepository.findAll(PageRequest.of(page, size));
	}

}
