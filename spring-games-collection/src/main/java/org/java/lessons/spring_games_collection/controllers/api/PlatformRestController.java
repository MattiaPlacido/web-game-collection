package org.java.lessons.spring_games_collection.controllers.api;

import java.util.List;
import java.util.Optional;

import org.java.lessons.spring_games_collection.models.Platform;
import org.java.lessons.spring_games_collection.services.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin
@RequestMapping("/api/platforms")
public class PlatformRestController {

    @Autowired
    private PlatformService platformService;

    @GetMapping
    public ResponseEntity<List<Platform>> index(@RequestParam(required = false) String name) {
        if (name == null || name.isEmpty()) {
            return new ResponseEntity<List<Platform>>(platformService.getAll(), HttpStatus.OK);
        }

        List<Platform> platforms = platformService.getByName(name);

        if (platforms.isEmpty()) {
            return new ResponseEntity<List<Platform>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Platform>>(platforms, HttpStatus.OK);
    }

    // Metodi scritti non utilizzati che tanto vale non cancello

    // @GetMapping("/{id}")
    // public ResponseEntity<Platform> show(@PathVariable Integer id) {
    // Optional<Platform> platformAttempt = platformService.getById(id);

    // if (platformAttempt.isEmpty()) {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }

    // return new ResponseEntity<Platform>(platformAttempt.get(), HttpStatus.OK);
    // }

}
