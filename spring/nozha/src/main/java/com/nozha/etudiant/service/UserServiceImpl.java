package com.nozha.etudiant.service;

import java.util.List;

import com.nozha.etudiant.entities.User;
import com.nozha.etudiant.repos.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository UserRepository;

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return UserRepository.findAll();
	}

	@Override
	public User saveUser(User e) {
		// TODO Auto-generated method stub
		return UserRepository.save(e);
	}

	@Override
	public User updateUser(User e) {
		// TODO Auto-generated method stub
		return UserRepository.save(e);
	}

	@Override
	public void deleteUser(User e) {
		UserRepository.delete(e);
		
	}

	@Override
	public void deleteUserById(Long id) {
		UserRepository.deleteById(id);		
	}

	@Override
	public User getUser(Long id) {
		return UserRepository.getById(id);
	}

	@Override
	public Page<User> getAllUsersParPage(int page, int size) {
		return UserRepository.findAll(PageRequest.of(page, size));
	}

}
