package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="film")
public class PartialFilm {
    @Id
    @Column(name="film_id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmID;


    @Column(name = "title")
    private String title;


    @Column(name = "description")
    private String description;

    public PartialFilm() {
    }

    public PartialFilm(int filmID, String title, String description) {
        this.filmID = filmID;
        this.title = title;
        this.description = description;
    }

    public PartialFilm(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
