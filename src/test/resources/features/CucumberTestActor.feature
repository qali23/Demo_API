Feature: does a new Actor Initialise properly?
  Do all the fields match what they are expected to match?

  Scenario: First name and last name are set
    Given a new actor has been made
    And firstName is set as "Henry"
    And lastName is set as "Yrneh"
    When I check what the actors first name is
    And check what the actors last name is
    Then the firstName should read "Henry"
    And the lastName should read "Yrneh"

  Scenario: The actor has no films that they have acted in yet
    Given a new actor has been made
    And no films have been added to the list of films that actor has acted in
    When I check the contents of the film array
    Then it should be null