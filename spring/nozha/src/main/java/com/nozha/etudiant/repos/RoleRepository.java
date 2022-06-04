package com.nozha.etudiant.repos;

import com.nozha.etudiant.entities.Role;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository  extends JpaRepository<Role, Long> {

}
