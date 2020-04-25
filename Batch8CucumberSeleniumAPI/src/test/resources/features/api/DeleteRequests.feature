@api @delete
Feature: I am testing delete requests for Go Rest API
    
  Scenario: Delete request to update user in the Go Rest DB
    Given Go rest API is up and running
    And I have a new user created in the system
    When I hit the api with delete request
    Then API should delete the user
    And get request to the user should not return the user

  