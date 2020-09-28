@petAPITest
Feature: Test the Pet API on Swagger

  @postPet
  Scenario: Add a new pet to the Store
    Given the user builds the postPet API
    When the user runs the postPet API
    Then the API will be run successfully

  @getPet
  Scenario: Get the pet from the store and verify details are correct
    Given the user builds the getPet API
    When the user runs the getPet API
    And the verifies the details are correct
    Then the details will be returned correctly

  @updatePet
  Scenario: Update the pet name and verify that changes are correct
    Given the user builds the postPetUpdate API to up
    When the user runs the postPetUpdate API
    Then the API will update the pet's name
    And the name will be verified as changed.

  @deletePet
  Scenario: Delete the pet from the Pet Store and verify that it has been removed
    Given the user builds the deletePet API
    When the user runs the deletePet API
    Then the pet will be deleted
    And verified as no longer existing on database