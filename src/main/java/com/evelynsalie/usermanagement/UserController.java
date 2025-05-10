package com.evelynsalie.usermanagement;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.StringBuilder;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import java.util.Map;

import com.evelynsalie.usermanagement.services.UserService;

@RestController
@RequestMapping("/api/users/")
public class UserController {
    private final UserService userService;
	
	@Autowired
	public UserController(InMemoryDataSource data) {
		System.out.println("Instantiating controller...");
		this.userService = userService;
	}
	
	@GetMapping
	public ResponseEntity<String> getUsers() {
		StringBuilder ret = new StringBuilder("Users:\n");
		for (Map<String, Object> fields : userService.getAllUsers()) {
			String firstName = (String) fields.get("first_name");
			String lastName = (String) fields.get("last_name");
			ret.append(firstName + ", " + lastName + "\n");
		}
		return ResponseEntity.ok(ret.toString());
	}

	@GetMapping("/{id}")
	public ResponseEntity<String> getUserById(@PathVariable Long id) {
		return ResponseEntity.ok("Getting User " + id + "...");
	}

	@PostMapping
	public ResponseEntity<String> postUser(@RequestBody String data) {
		return ResponseEntity.ok("Creating User from '" + data + "'...");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		return ResponseEntity.ok("Deleting User " + id + "...");
	}
}
