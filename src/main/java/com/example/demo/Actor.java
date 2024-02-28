package com.example.demo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="actor")
public class Actor {
    @Id
    @Column(name="actor_id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actorID;


    @ManyToMany
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id"))
    Set<PartialFilm> filmsActedIn;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public Actor() {
        this.filmsActedIn = new HashSet<>();
    }

    public Actor(int actorID, Set<PartialFilm> filmsActedIn, String firstName, String lastName) {
        this.actorID = actorID;
        this.filmsActedIn = filmsActedIn;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Set<PartialFilm> getFilmsActedIn() {
        return this.filmsActedIn;
    }

    public void setFilmsActedIn(Set<PartialFilm> filmsActedIn) {
        this.filmsActedIn = filmsActedIn;
    }

    public void addFilmForActor(PartialFilm film){
        this.filmsActedIn.add(film);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setActorID(int actorID) {
        this.actorID = actorID;
    }

    public int getActorID() {
        return actorID;
    }
}
