package org.java.lessons.spring_games_collection.controllers.api;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.java.lessons.spring_games_collection.models.Game;
import org.java.lessons.spring_games_collection.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin
@RequestMapping("/api/games")
public class GameRestController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<Game>> index(@RequestParam(required = false) String name) {
        if (name == null || name.isEmpty()) {
            return new ResponseEntity<List<Game>>(gameService.getAll(), HttpStatus.OK);
        }

        List<Game> games = gameService.getByName(name);

        if (games.isEmpty()) {
            return new ResponseEntity<List<Game>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Game>>(games, HttpStatus.OK);
    }

    // Metodi scritti non utilizzati che tanto vale non cancello

    // @GetMapping("/{id}")
    // public ResponseEntity<Game> getMethodName(@PathVariable Integer id) {
    // Optional<Game> gameAttempt = gameService.getById(id);

    // if (gameAttempt.isEmpty()) {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }

    // return new ResponseEntity<Game>(gameAttempt.get(), HttpStatus.OK);
    // }

    // @PostMapping
    // public ResponseEntity<Game> store(@Valid @RequestBody Game game) {
    // if (game.getId() != null) {
    // return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    // }

    // return new ResponseEntity<Game>(gameService.create(game), HttpStatus.OK);
    // }

    // @PutMapping("/{id}")
    // public ResponseEntity<Game> update(@PathVariable Integer id, @Valid
    // @RequestBody Game game) {
    // if (!gameService.existsById(id)) {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
    // game.setId(id);
    // return new ResponseEntity<Game>(gameService.update(game), HttpStatus.OK);
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Game> delete(@Valid @PathVariable Integer id) {
    // if (!gameService.existsById(id)) {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }

    // gameService.deleteById(id);
    // return new ResponseEntity<Game>(HttpStatus.OK);
    // }

}
