@ui @searchMultipleProducts
Feature: Search Mutiple Product Fuctionality
  I want to use this template for my feature file

  @TC0037
  Scenario: Search Mutiple Products
    Given I have browser opened and url is navigated
    When I search for and add single product of each category as below
      | Laptop   |
      | Computer |
      | LED TV   |
      | Computer |
      | Laptop   |
      | LED TV   |
      | Laptop   |
      | Computer |
      | Laptop   |
      | LED TV   |   
    Then All the products should be added in the cart
