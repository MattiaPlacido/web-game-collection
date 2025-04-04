package org.java.lessons.spring_games_collection.repositories;

import java.util.List;

import org.java.lessons.spring_games_collection.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {

    public List<Game> findByNameContainingIgnoreCase(String name);

}
