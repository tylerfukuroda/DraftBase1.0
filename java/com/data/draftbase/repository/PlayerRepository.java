package com.data.draftbase.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.data.draftbase.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long>{
	
	List<Player> findAll();
	Optional<Player> findPlayerById(Long id);
	Optional<Player> findPlayerByFirstName(String firstName);
	Optional<Player> findPlayerByLastName(String lastName);
	
	
}
