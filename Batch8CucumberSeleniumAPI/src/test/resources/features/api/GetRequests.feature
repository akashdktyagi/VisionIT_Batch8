@get
Feature: I am testing get request for Go Rest API

  Scenario: Get request to fetch all users
    Given Go rest API is up and running
    When I hit the api with get request and end point as "/public-api/users"
    Then API should return all the users
    
  Scenario: Get request to validate pagination
    Given Go rest API is up and running
    When I hit the api with get request and end point as "/public-api/users"
    Then API should return all the users with specific pagination value

   Scenario: Get request to fetch single User
    Given Go rest API is up and running
    When I hit the api with get request and end point as "/public-api/users/133"
    Then API should return single user details