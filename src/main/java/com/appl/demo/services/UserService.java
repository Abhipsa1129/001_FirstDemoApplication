package com.appl.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appl.demo.model.User;
import com.appl.demo.repository.IUserRepo;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	@Autowired
	private final IUserRepo userRepo;

	public UserService(IUserRepo userRepo) {
		this.userRepo = userRepo;
	}

	public int saveUser(User user) {
		User userr = userRepo.save(user);
		return userr.getUserId();
	}

	public Iterable<User> getAllUsers() {
		return userRepo.findAll();
	}

	public Optional<User> getUser(int userId) {
		return userRepo.findById(userId);
	}

	public User updateUser(User user) {
		if (!userRepo.findById(user.getUserId()).isEmpty()) {
			return userRepo.save(user);
		} else {
			return null;
		}
	}

	public void deleteUser(int userId) {
		userRepo.deleteById(userId);
	}

}
