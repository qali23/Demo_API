package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartialActorRepository extends JpaRepository<PartialActor,Integer>{
    List<PartialActor> findByFirstNameAndLastName(String firstName, String lastName);
    List<PartialActor> findByLastName(String lastName);
    List<PartialActor> findByFirstName(String firstName);

}
