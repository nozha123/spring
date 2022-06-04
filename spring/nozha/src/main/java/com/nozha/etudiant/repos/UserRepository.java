package com.nozha.etudiant.repos;

import com.nozha.etudiant.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
      User findByUsername (String username);
}
