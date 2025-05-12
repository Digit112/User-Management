package com.evelynsalie.usermanagement.controllers;

import com.evelynsalie.usermanagement.services.UserService;
import com.evelynsalie.usermanagement.entities.User;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.StringBuilder;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.List;
import javax.sql.DataSource;

@RestController
@RequestMapping("/api/users/")
public class UserController {
    private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		System.out.println("Instantiating controller...");
		this.userService = userService;
	}
	
	@GetMapping
	public List<User> getUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	@PostMapping
	public ResponseEntity<String> postUser(@RequestBody String data) {
		final ObjectMapper mapper = new ObjectMapper();
		
		try {
			User user = mapper.readValue(data, User.class);
			userService.createUser(user.getFirstName(), user.getLastName());
			return ResponseEntity.ok("Creating User from '" + data + "'...");
		}
		catch (JsonProcessingException e) {
			System.out.println(e.getMessage());
			return ResponseEntity.badRequest().body("Invalid JSON");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		return ResponseEntity.ok("Deleting User " + id + "...");
	}
}
