package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor,Integer>{
    List<PartialActor> findByFirstNameAndLastName(String firstName, String lastName);
    List<Actor> findActorByFirstNameAndLastName(String firstName, String lastName);

    List<PartialActor> findByLastName(String lastName);
    List<PartialActor> findByFirstName(String firstName);

}
