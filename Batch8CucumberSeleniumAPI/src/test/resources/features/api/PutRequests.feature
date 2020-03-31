@put
Feature: I am testing put request for Go Rest API

  Scenario: Put request to update user in the Go Rest DB
    Given Go rest API is up and running
    And I have a new user created in the system
    When I hit the api with put request to update the existing user details
    Then API should update the user
    And get request to the user should return updated information
    
  Scenario: Put Request, valdiation message is received when wrong gender and email is sent
    Given Go rest API is up and running
    And I have a new user created in the system
    When I hit the api with put request and setting wrong email
    Then API returned the error code as 422
    And error message displayed as "Email is not a valid email address."
    
  Scenario: Put request to update in-correct user then valdiation message is thrown
    Given Go rest API is up and running
    When I hit the api with put request to update the incorrect user
    Then API returned the error code as 404
    And error message displayed as "Object not found:"  
  