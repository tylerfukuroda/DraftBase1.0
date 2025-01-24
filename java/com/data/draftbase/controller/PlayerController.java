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

import com.data.draftbase.entity.Player;
import com.data.draftbase.service.PlayerService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping(value = "/api")
public class PlayerController {
	
	@Autowired
	PlayerService playerService;
	
	@GetMapping("/players/{id}")
	public ResponseEntity<Optional<Player>> findPlayerById(@PathVariable Long id){
		Optional<Player> player = playerService.findPlayerById(id);
		return ResponseEntity.ok(player);
	}
	
	@GetMapping("/players")
	public ResponseEntity<List<Player>> getAllPlayers(){
		System.out.println("Action requested");
		List<Player> allPlayers = playerService.getAllPlayers();
		return ResponseEntity.ok(allPlayers);
	}
	
	@GetMapping("/players/firstNameSearch/{firstName}")
	public ResponseEntity<Optional<Player>> findPlayerByFirstName(@PathVariable String firstName){
		Optional<Player> playersByFirstName = playerService.findPlayerByFirstName(firstName);
		return ResponseEntity.ok(playersByFirstName);
	}
	
	@GetMapping("/players/lastNameSearch/{lastName}")
	public ResponseEntity<Optional<Player>> findPlayerByLastName(@PathVariable String lastName){
		Optional<Player> playersByLastName = playerService.findPlayerByLastName(lastName);
		return ResponseEntity.ok(playersByLastName);
	}
	
	@PostMapping("/players/add")
	public ResponseEntity<Player> createPlayer(@RequestBody Player player){
		Player createdPlayer = playerService.createPlayer(player);
		return ResponseEntity.ok(createdPlayer);
	}
	
	@DeleteMapping("/players/remove")
	public ResponseEntity<Void> deletePlayer(@RequestBody Player player){
		playerService.deletePlayer(player);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/players/update/{id}")
	public ResponseEntity<Player> updatePlayer(@RequestBody Long id, Player playerDetails){
		try {
			Player existingPlayer = playerService.updatePlayer(id, playerDetails);
			return ResponseEntity.ok(existingPlayer);
		} catch(EntityNotFoundException e){
			return ResponseEntity.notFound().build();
		}
	}
	
}
