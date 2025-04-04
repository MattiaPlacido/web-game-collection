package org.java.lessons.spring_games_collection.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "platforms")
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name must not be null, blank or empty.")
    private String name;

    @NotBlank(message = "PublishingCompany must not be null, blank or empty.")
    private String publishingCompany;

    @Lob
    private String description;

    @ManyToMany(mappedBy = "platforms")
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

    public String getPublishingCompany() {
        return this.publishingCompany;
    }

    public void setPublishingCompany(String value) {
        this.publishingCompany = value;
    }

    public Set<Game> getGames() {
        return this.games;
    }

    public void setGames(Set<Game> value) {
        this.games = value;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String value) {
        this.description = value;
    }
}
