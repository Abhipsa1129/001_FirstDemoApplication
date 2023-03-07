package com.appl.demo.tesr;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.appl.demo.FirstDemoApplication;
import com.appl.demo.model.User;
import com.appl.demo.services.UserService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes=FirstDemoApplication.class)
@Transactional
//@Rollback(false)
class UserServiceTests {

	@Autowired
	UserService userService;
	
	
	@Test
	public void testSaveUser() {
		User user = new User(6, "Abhipsa", "Tripathy", 25, "BBSR", "Country");
		int empId = userService.saveUser(user);
		Assertions.assertTrue(empId>5);
	}
	
	@Test
	public void testGetAllUsers() {
		Iterable<User> users = userService.getAllUsers();
		Assertions.assertNotNull(users);
	}
	
	@Test
	public void testGetUserByValidId() {
		int userId = 2;
		Optional<User> user =  userService.getUser(userId);
		User us = user.orElse(null);
		Assertions.assertNotNull(us);
	}
	
	@Test
	public void testGetUserByInValidId() {
		int userId = 8;
		Optional<User> user =  userService.getUser(userId);
		User us = user.orElse(null);
		Assertions.assertNull(us);
	}
	
	@Test
	public void testUpdateUserByValidId() {
		User user = new User(4, "Sushree", "Ghosh", 25, "BBSR", "Country");
		User us = userService.updateUser(user);
		Assertions.assertNotNull(us);
	}
	
	@Test
	public void testUpdateUserByInValidId() {
		User user = new User(8, "Sushree", "Ghosh", 25, "BBSR", "Country");
		User us = userService.updateUser(user);
		Assertions.assertNull(us);
	}

}
