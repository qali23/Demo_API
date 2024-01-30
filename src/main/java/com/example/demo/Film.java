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

    public Film(int filmID, Set<Actor> actorsInFilm, Set<Category> categoriesOfFilm, String title) {
        this.filmID = filmID;
        this.actorsInFilm = actorsInFilm;
        this.categoriesOfFilm = categoriesOfFilm;
        this.title = title;
    }

    public Film() {
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
