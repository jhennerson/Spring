package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

@Service //@Component
public class GameService {
	
	@Autowired //injetando uma instância de GameRepository no GameService
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true) //não irá bloquear o banco de dados para escrita
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();		
		return new GameDTO(result);
	}

	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList(); //transforma uma list de games em uma list de DTO
	}
}
