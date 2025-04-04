package org.java.lessons.spring_games_collection.services;

import java.util.List;
import java.util.Optional;

import org.java.lessons.spring_games_collection.models.Game;
import org.java.lessons.spring_games_collection.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAll() {
        return gameRepository.findAll();
    }

    public List<Game> getByName(String searchterm) {
        return gameRepository.findByNameContainingIgnoreCase(searchterm);
    }

    // Optional logic gets handled by the controller
    public Optional<Game> getById(Integer id) {
        return gameRepository.findById(id);
    }

    public Game create(Game game) {
        return gameRepository.save(game);
    }

    public Game update(Game game) {
        return gameRepository.save(game);
    }

    public void delete(Game game) {
        gameRepository.delete(game);
    }

    public void deleteById(Integer id) {
        Game toDelete = getById(id).get();
        delete(toDelete);
    }

    public boolean existsById(Integer id) {
        return gameRepository.existsById(id);
    }

    public boolean exists(Game game) {
        return existsById(game.getId());
    }

}
