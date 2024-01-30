package com.example.demo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

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
    Set<Film> filmsActedIn;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public Actor() {
    }

    public Actor(int actorID, Set<Film> filmsActedIn, String firstName, String lastName) {
        this.actorID = actorID;
        this.filmsActedIn = filmsActedIn;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Set<Film> getFilmsActedIn() {
        return this.filmsActedIn;
    }

    public void setFilmsActedIn(Set<Film> filmsActedIn) {
        this.filmsActedIn = filmsActedIn;
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
