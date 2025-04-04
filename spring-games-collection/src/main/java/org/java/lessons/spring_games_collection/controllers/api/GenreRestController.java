package org.java.lessons.spring_games_collection.controllers.api;

import java.util.List;
import java.util.Optional;

import org.java.lessons.spring_games_collection.models.Genre;
import org.java.lessons.spring_games_collection.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin
@RequestMapping("/api/genres")

public class GenreRestController {

    @Autowired
    private GenreService genreService;

    @GetMapping
    public ResponseEntity<List<Genre>> index(@RequestParam(required = false) String name) {
        if (name == null || name.isEmpty()) {
            return new ResponseEntity<List<Genre>>(genreService.getAll(), HttpStatus.OK);
        }

        List<Genre> genres = genreService.getByName(name);

        if (genres.isEmpty()) {
            return new ResponseEntity<List<Genre>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Genre>>(genres, HttpStatus.OK);
    }

    // Metodi scritti non utilizzati che tanto vale non cancello

    // @GetMapping("/{id}")
    // public ResponseEntity<Genre> show(@PathVariable Integer id) {
    // Optional<Genre> genreAttempt = genreService.getById(id);

    // if (genreAttempt.isEmpty()) {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }

    // return new ResponseEntity<Genre>(genreAttempt.get(), HttpStatus.OK);
    // }

}
