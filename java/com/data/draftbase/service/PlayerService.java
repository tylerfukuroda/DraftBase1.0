package com.data.draftbase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.draftbase.entity.Player;
import com.data.draftbase.repository.PlayerRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PlayerService {
	
	@Autowired
	PlayerRepository playerRepository;
	
	public Optional<Player> findPlayerById(Long id) {
		return playerRepository.findPlayerById(id);
	}
	
	public Optional<Player> findPlayerByFirstName(String firstName) {
		return playerRepository.findPlayerByFirstName(firstName);
	}
	
	public Optional<Player> findPlayerByLastName(String lastName ) {
		return playerRepository.findPlayerByLastName(lastName);
	}
	
	public Player createPlayer(Player player) {
		return playerRepository.save(player);
	}
	
	public void deletePlayer(Player player) {
		playerRepository.delete(player);
	}
	
	public List<Player> getAllPlayers() {
		return playerRepository.findAll();
	}
	
	public Player updatePlayer(Long id, Player playerDetails) {
		Player existingPlayer = playerRepository.findPlayerById(id)
				.orElseThrow(() -> new EntityNotFoundException("Player not found."));
		existingPlayer.setFirstName(playerDetails.getFirstName());
		existingPlayer.setLastName(playerDetails.getLastName());
		existingPlayer.setPosition(playerDetails.getPosition());
		existingPlayer.setHeight(playerDetails.getHeight());
		existingPlayer.setAge(playerDetails.getWeight());
		existingPlayer.setDraftClass(playerDetails.getDraftClass());
		existingPlayer.setSchool(playerDetails.getSchool());
		
		playerRepository.save(existingPlayer);
		
		return existingPlayer;
	}
	
}
