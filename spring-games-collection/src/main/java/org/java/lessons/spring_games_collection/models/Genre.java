package org.java.lessons.spring_games_collection.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "genres")
public class Genre {

    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name must not be null, blank or empty.")
    private String name;

    @Lob
    private String description;

    public enum GameTargetAudience {
        ANY,
        FAMILY,
        ADULT,
        TEEN;
    }

    @Enumerated(EnumType.STRING)
    private GameTargetAudience targetAudience;

    @ManyToMany(mappedBy = "genres")
    @JsonBackReference
    private Set<Game> games;

    // Methods

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer value) {
        this.id = value;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public GameTargetAudience getTargetAudience() {
        return this.targetAudience;
    }

    public void setTargetAudience(GameTargetAudience value) {
        this.targetAudience = value;
    }

    public Set<Game> getGames() {
        return this.games;
    }

    public void setGames(Set<Game> value) {
        this.games = value;
    }
}
