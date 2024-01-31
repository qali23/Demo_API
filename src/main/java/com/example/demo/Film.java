package com.example.demo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="film")
public class Film {
    @Id
    @Column(name="film_id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmID;

    @JsonIgnore
    @ManyToMany(mappedBy = "filmsActedIn")
    Set<Actor> actorsInFilm;

    @ManyToMany
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    Set<Category> categoriesOfFilm;

    @Column(name = "title")
    private String title;

    @Column(name = "language_id")
    private int language_id;

    @Column(name = "description")
    private String description;

    public Film() {
    }

    public Film(int filmID, Set<Actor> actorsInFilm, Set<Category> categoriesOfFilm, String title, int language_id, String description) {
        this.filmID = filmID;
        this.actorsInFilm = actorsInFilm;
        this.categoriesOfFilm = categoriesOfFilm;
        this.title = title;
        this.language_id = language_id;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Category> getCategoriesOfFilm() {
        return categoriesOfFilm;
    }

    public void setCategoriesOfFilm(Set<Category> categoriesOfFilm) {
        this.categoriesOfFilm = categoriesOfFilm;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }


    public Set<Actor> getActorsInFilm() {
        return actorsInFilm;
    }

    public void setActorsInFilm(Set<Actor> actorsInFilm) {
        this.actorsInFilm = actorsInFilm;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    public int getFilmID() {
        return filmID;
    }

}
