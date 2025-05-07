import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class Api {
	@GetMapping("/users")
	public ResponseEntity<String> getUsers() {
		return "Hello, World!";
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<String> getUserById(@PathVariable Long id) {
		return "Hello, World!";
	}

	@PostMapping("/users")
	public ResponseEntity<String> postUser(@RequestBody String data) {
		return ResponseEntity.ok("Data received: " + data);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		return "Hello, World!";
	}
}
