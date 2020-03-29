@post
Feature: I am testing post request for Go Rest API

  Scenario: Post request to create a user in the Go Rest DB
    Given Go rest API is up and running
    And I set header and body to create new user
    When I hit the api with post request and end point as "/public-api/users"
    Then API created a new User in the system
    And I can find the new user in the system when i get the user
    
  Scenario: Post request to validate error message when no body is sent
    Given Go rest API is up and running
    And I set header and but with out any body
    When I hit the api with post request and end point as "/public-api/users"
    Then API returned the error code as 422
    And error message displayed as "Email cannot be blank."
    And error message displayed as "First Name cannot be blank."
    And error message displayed as "Last Name cannot be blank."
    And error message displayed as "Gender cannot be blank."
    
  Scenario: Post request to validate error message when empty field values are sent in body
    Given Go rest API is up and running
    And I set header and body with fields but no values
    When I hit the api with post request and end point as "/public-api/users"
    Then API returned the error code as 422
    And error message displayed as "Email cannot be blank."
    And error message displayed as "First Name cannot be blank."
    And error message displayed as "Last Name cannot be blank."
    And error message displayed as "Gender cannot be blank."
    
  Scenario: Post request to validate error message when incorrect email and gender is sent in the body
    Given Go rest API is up and running
    And I set header and body with incorrect email and gender
    When I hit the api with post request and end point as "/public-api/users"
    Then API returned the error code as 422
    And error message displayed as "Email is not a valid email address."
    And error message displayed as "Gender is invalid."
    
  Scenario: Post request to validate error message when incorrect data types for all fields are sent
    Given Go rest API is up and running
    And I set header and body with incorrect data types are sent for every mandatory field
    When I hit the api with post request and end point as "/public-api/users"
    Then API returned the error code as 422
    And error message displayed as "Gender must be a string."
    And error message displayed as "Email is not a valid email address."
    And error message displayed as "First Name must be a string."
    And error message displayed as "Last Name must be a string."
