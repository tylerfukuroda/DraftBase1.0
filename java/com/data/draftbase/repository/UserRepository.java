package com.data.draftbase.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.data.draftbase.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("Select u from User u Where u.id = :id")
	Optional<User> findUserById(@Param("id") Long id);
	
	@Query("Select u from User u Where u.firstName = :firstName")
	Optional<User> findUserByFirstName(@Param("firstName") String firstName);
	
	@Query("Select u from User u Where u.lastName = :lastName")
	Optional<User> findUserByLastName(@Param("lastName") String lastName);
	
	@Query("Select u from User u where u.username = :username")
	Optional<User> findUserByUsername(@Param("username") String username);
	
	@Query("Select u from User u where u.email = :email")
	Optional<User> findUserByEmail(@Param("email") String email);
	
	
}
