package com.evelynsalie.usermanagement;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/users/")
public class UserController {
	public UserController() {
		System.out.println("Instantiating controller...");
	}
	
	@GetMapping
	public ResponseEntity<String> getUsers() {
		return ResponseEntity.ok("Getting Users...");
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
