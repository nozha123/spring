package com.nozha.etudiant.repos;

import com.nozha.etudiant.entities.Formation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepository extends JpaRepository<Formation, Long> {

}
