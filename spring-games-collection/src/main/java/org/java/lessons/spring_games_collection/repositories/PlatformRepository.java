package org.java.lessons.spring_games_collection.repositories;

import java.util.List;

import org.java.lessons.spring_games_collection.models.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformRepository extends JpaRepository<Platform, Integer> {

    public List<Platform> findByNameContainingIgnoreCase(String name);

}
