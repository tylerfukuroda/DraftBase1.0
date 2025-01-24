package com.data.draftbase.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.draftbase.entity.User;
import com.data.draftbase.service.UserService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping(value = "/userbase")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/users/findAllUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> allUsers = userService.getAllUsers();
		System.out.println("User list requested: Successful");
		return ResponseEntity.ok(allUsers);
	}
	
	
	@GetMapping("/users/search/findByUserId/{id}")
	public ResponseEntity<Optional<User>> findUserById(@PathVariable Long id){
		Optional<User> user = userService.findById(id);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/users/search/firstName/{firstName}")
	public ResponseEntity<Optional<User>> findUserByFirstName(@PathVariable String firstName){
		Optional<User> userByFirstName = userService.findByFirstName(firstName);
		return ResponseEntity.ok(userByFirstName);
	}
	
	@GetMapping("/users/search/lastName/{lastName}")
	public ResponseEntity<Optional<User>> findUserByLastName(@PathVariable String lastName){
		Optional<User> userByLastName = userService.findByLastName(lastName);
		return ResponseEntity.ok(userByLastName);
	}
	
	@GetMapping("/users/search/email/{email}")
	public ResponseEntity<Optional<User>> findUserByEmail(@PathVariable String email){
		Optional<User> userByEmail = userService.findByEmail(email);
		return ResponseEntity.ok(userByEmail);
	}
	
	@GetMapping("/users/search/username/{username}")
	public ResponseEntity<Optional<User>> findUserByUsername(@PathVariable String username){
		Optional<User> userByUsername = userService.findByUsername(username);
		return ResponseEntity.ok(userByUsername);
	}
	
	@PostMapping("/users/create_user")
	public ResponseEntity<User> createUser(User user){
		User newUser = userService.createUser(user);
		return ResponseEntity.ok(newUser);
	}
	
	@DeleteMapping("/users/delete_user)")
	public ResponseEntity<Void> deleteUser(User user){
		userService.deleteUser(user);
		System.out.println(user + " has been deleted.");
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/users/updateUser/{id}")
	public ResponseEntity<User> updateUser(@RequestBody Long id, User user){
		try {
			User existingUser = userService.updateUser(id, user);
			return ResponseEntity.ok(existingUser);
		} catch(EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
}
