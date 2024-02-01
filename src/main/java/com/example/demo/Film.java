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

    @ManyToMany
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    Set<PartialActor> actorsInFilm;

    @ManyToMany
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    Set<PartialCategory> categoriesOfFilm;

    @Column(name = "title")
    private String title;

    @Column(name = "language_id")
    private int language_id;

    @Column(name = "description")
    private String description;

    public Film() {
    }

    public Film(int filmID, Set<PartialActor> actorsInFilm, Set<PartialCategory> categoriesOfFilm, String title, int language_id, String description) {
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

    public Set<PartialCategory> getCategoriesOfFilm() {
        return categoriesOfFilm;
    }

    public void addActorForFilm(PartialActor actor) {
        if (!this.actorsInFilm.contains(actor)) {
            this.actorsInFilm.add(actor);
        }
    }

    public void addCatgegoryForFilm(PartialCategory category){
        if (!this.categoriesOfFilm.contains(category)) {
            this.categoriesOfFilm.add(category);
        }
    }

    public void setCategoriesOfFilm(Set<PartialCategory> categoriesOfFilm) {
        this.categoriesOfFilm = categoriesOfFilm;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }


    public Set<PartialActor> getActorsInFilm() {
        return actorsInFilm;
    }

    public void setActorsInFilm(Set<PartialActor> actorsInFilm) {
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
