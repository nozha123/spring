package com.nozha.etudiant.service;

import java.util.List;

import com.nozha.etudiant.entities.Role;
import com.nozha.etudiant.repos.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

}
