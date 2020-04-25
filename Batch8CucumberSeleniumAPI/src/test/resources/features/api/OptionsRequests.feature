@api @options
Feature: I am testing options request Go Rest API
    
  Scenario: Options request to check available methods
    Given Go rest API is up and running
    When I hit the api with options request
		Then API should return the list of available methods  
  