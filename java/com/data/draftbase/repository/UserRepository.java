package com.data.draftbase.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.data.draftbase.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findUserById(Long id);
	Optional<User> findUserByFirstName(String firstName);
	Optional<User> findUserByLastName(String lastName);
	Optional<User> findUserByUsername(String username);
	Optional<User> findUserByEmail(String email);
	
	
}
