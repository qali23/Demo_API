package com.example.demo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CucumberTests {
    //Actor Cucumber tests

    private String firstName = "Henry";
    private String lastName = "Yrneh";

    Actor actor;
    PartialActor partialActor;

    String realFirstName;
    String realLastName;


    @Given("a new actor has been made")
    public void aNewActorHasBeenMade() {
        actor = new Actor();
    }
    @And("firstName is set as {string}")
    public void firstnameIsSetAs(String arg0) {
        actor.setFirstName(arg0);
    }
    @And("lastName is set as {string}")
    public void lastnameIsSetAs(String arg0) {
        actor.setLastName(arg0);
    }
    @When("I check what the actors first name is")
    public void iCheckWhatTheActorsFirstNameIs() {
        realFirstName = actor.getFirstName();
    }
    @And("check what the actors last name is")
    public void checkWhatTheActorsLastNameIs() {
        realLastName = actor.getLastName();
    }
    @Then("the firstName should read {string}")
    public void theFirstNameShouldRead(String arg0) {
        assertEquals(firstName,realFirstName);
    }
    @And("the lastName should read {string}")
    public void theLastNameShouldRead(String arg0) {
        assertEquals(lastName,realLastName);
    }


    @And("no films have been added to the list of films that actor has acted in")
    public void noFilmsHaveBeenAddedToTheListOfFilmsThatActorHasActedIn() {
    }
    @When("I check the contents of the film array")
    public void iCheckTheContentsOfTheFilmArray() {
    }
    @Then("it should be null")
    public void itShouldBeNull() {
        assertNull(actor.getFilmsActedIn());
    }
}