package org.java.lessons.spring_games_collection.repositories;

import java.util.List;

import org.java.lessons.spring_games_collection.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

    public List<Genre> findByNameContainingIgnoreCase(String name);

}
