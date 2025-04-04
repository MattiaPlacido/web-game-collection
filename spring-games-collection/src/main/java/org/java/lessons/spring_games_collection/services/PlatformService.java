package org.java.lessons.spring_games_collection.services;

import java.util.List;
import java.util.Optional;

import org.java.lessons.spring_games_collection.models.Game;
import org.java.lessons.spring_games_collection.models.Platform;
import org.java.lessons.spring_games_collection.repositories.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatformService {

    @Autowired
    private PlatformRepository platformRepository;

    public List<Platform> getAll() {
        return platformRepository.findAll();
    }

    public List<Platform> getByName(String searchterm) {
        return platformRepository.findByNameContainingIgnoreCase(searchterm);
    }

    // Optional logic gets handled by the controller
    public Optional<Platform> getById(Integer id) {
        return platformRepository.findById(id);
    }

    public Platform create(Platform platform) {
        return platformRepository.save(platform);
    }

    public Platform update(Platform platform) {
        return platformRepository.save(platform);
    }

    public void delete(Platform platform) {
        for (Game linkedGame : platform.getGames()) {
            linkedGame.getPlatforms().remove(platform);
        }
        platformRepository.delete(platform);
    }

    public void deleteById(Integer id) {
        Platform toDelete = getById(id).get();
        delete(toDelete);
    }

    public boolean existsById(Integer id) {
        return platformRepository.existsById(id);
    }

    public boolean exists(Platform platform) {
        return existsById(platform.getId());
    }
}
