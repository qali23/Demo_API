package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor,Integer>{
    List<Actor> findByFirstNameAndLastName(String firstName, String lastName);

}
