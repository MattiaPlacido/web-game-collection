package org.java.lessons.spring_games_collection.models;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "games")
public class Game {

    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name must not be null, blank or empty.")
    private String name;

    @Lob
    private String description;

    @NotNull(message = "There must be a release date.")
    private LocalDate releaseDate;

    @NotBlank(message = "Publisher must not be null, blank or empty.")
    private String publisher;

    private String imageUrl;

    @ManyToMany
    @JoinTable(name = "game_genre", joinColumns = @JoinColumn(name = "game_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres;

    @ManyToMany
    @JoinTable(name = "game_platform", joinColumns = @JoinColumn(name = "game_id"), inverseJoinColumns = @JoinColumn(name = "platform_id"))
    private Set<Platform> platforms;

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

    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(LocalDate value) {
        this.releaseDate = value;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String value) {
        this.publisher = value;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String value) {
        this.imageUrl = value;
    }

    public Set<Genre> getGenres() {
        return this.genres;
    }

    public void setGenres(Set<Genre> value) {
        this.genres = value;
    }

    public Set<Platform> getPlatforms() {
        return this.platforms;
    }

    public void setPlatforms(Set<Platform> value) {
        this.platforms = value;
    }
}
