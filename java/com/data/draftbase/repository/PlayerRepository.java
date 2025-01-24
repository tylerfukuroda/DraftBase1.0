package com.data.draftbase.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.data.draftbase.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long>{
	
	List<Player> findAll();
	
	@Query("Select p FROM Player p Where p.id = :id")
	Optional<Player> findPlayerById(@Param("id") Long id);
	
	@Query("Select p FROM Player p Where p.firstName = :firstName")
	Optional<Player> findPlayerByFirstName(@Param("firstName") String firstName);
	
	@Query("Select p FROM Player p Where p.lastName = :lastName")
	Optional<Player> findPlayerByLastName(@Param("lastName") String lastName);
	
	
}
