package org.java.lessons.spring_games_collection.repositories;

import java.util.Optional;

import org.java.lessons.spring_games_collection.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    public Optional<User> findByUsername(String username);

}
