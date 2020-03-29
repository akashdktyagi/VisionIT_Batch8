@misc
Feature: I am testing patch request for Go Rest API

  Scenario: Patch request to update user in the Go Rest DB
    Given Go rest API is up and running
    And I have a new user created in the system
    When I hit the api with patch request to update the existing user details
    Then API should update the user
    And get request to the user should return updated information
   