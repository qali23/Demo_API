Feature: can you change the attributes of an actor?
  Can you change the first and last name of an actor, or add films to the films acted in array. You should not be able to change the ID

  Scenario: The name of the actor has been made
    Given a new actor has been made
    And the actor has a first and last name
    When I change the first and last name of the actor
    Then the first and last name should read the updated names

  Scenario: Trying to add a film to the films acted in array
    Given a new actor has been made
    And the actor has an ID
    And the actor has a first and last name
    When I add a film to the actors list of films they have acted in
    Then the film should be added to the array