package com.data.draftbase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.draftbase.entity.User;
import com.data.draftbase.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public Optional<User> findById(Long id) {
		return userRepository.findUserById(id);
	}
	
	public Optional<User> findByFirstName(String firstName) {
		return userRepository.findUserByFirstName(firstName);
	}
	
	public Optional<User>findByLastName(String lastName) {
		return userRepository.findUserByLastName(lastName);
	}
	
	public Optional<User> findByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}
	
	public Optional<User> findByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public void deleteUser(User user) {
		userRepository.delete(user);;
	}
	
	public User updateUser(Long id, User userDetails) {
		User existingUser = userRepository.findUserById(id)
				.orElseThrow(() -> new EntityNotFoundException("User not found."));
		existingUser.setFirstName(userDetails.getFirstName());
		existingUser.setLastName(userDetails.getLastName());
		existingUser.setUsername(userDetails.getUsername());
		existingUser.setEmail(userDetails.getEmail());
		existingUser.setActive(userDetails.isActive());
		existingUser.setAdmin(userDetails.isAdmin());
		
		userRepository.save(existingUser);
		System.out.println(existingUser.getFirstName() + " " + existingUser.getLastName() + " has been updated.");
		return existingUser;
	}
}
