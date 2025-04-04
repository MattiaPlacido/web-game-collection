package org.java.lessons.spring_games_collection.services;

import java.util.List;
import java.util.Optional;

import org.java.lessons.spring_games_collection.models.Game;
import org.java.lessons.spring_games_collection.models.Genre;
import org.java.lessons.spring_games_collection.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    public List<Genre> getByName(String searchterm) {
        return genreRepository.findByNameContainingIgnoreCase(searchterm);
    }

    // Optional logic gets handled by the controller
    public Optional<Genre> getById(Integer id) {
        return genreRepository.findById(id);
    }

    public Genre create(Genre genre) {
        return genreRepository.save(genre);
    }

    public Genre update(Genre genre) {
        return genreRepository.save(genre);
    }

    public void delete(Genre genre) {
        for (Game linkedGame : genre.getGames()) {
            linkedGame.getGenres().remove(genre);
        }
        genreRepository.delete(genre);
    }

    public void deleteById(Integer id) {
        Genre toDelete = getById(id).get();
        delete(toDelete);
    }

    public boolean existsById(Integer id) {
        return genreRepository.existsById(id);
    }

    public boolean exists(Genre genre) {
        return existsById(genre.getId());
    }

}
