package com.appl.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.appl.demo.model.User;
import com.appl.demo.services.UserService;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private UserService userService;

	@PostMapping("/save-user")
	public String saveUser(@Validated @RequestBody User user) {

		userService.saveUser(user);
		return "User is saved";
	}

	@GetMapping("/getUserDetail/{id}")
	public Optional<User> getUserDetail(@PathVariable("id") int userId) {

		Optional<User> user = userService.getUser(userId);
		return user;
	}
	
	@GetMapping("/get-all-users")
	public Iterable<User> getAllUsers() {

		Iterable<User> user = userService.getAllUsers();
		return user;
	}

	@PutMapping("/update-user")
	public String updateUser(@RequestBody User user) {

		User res = userService.updateUser(user);
		if(res != null) {
			return "User is updated";
		}else {
			return "User not found";
		}
		
	}
	
	@DeleteMapping("/delete-user")
	public String deleteUser(@RequestParam("id") int userId) {

		userService.deleteUser(userId);
		return "User is Deleted";
	}
	
	
	//Testing
	@GetMapping("/getUser")
	public User getUserDtlById(@RequestBody User user) {
		
		int userId = user.getUserId();
		
		User us = userService.getUser(userId).get();
		return us;
	}
}
