@ui @AddToCart
Feature: Add to cart functionality
 
  @TC0032
  Scenario: User should be able to Remove the items from Add To Cart list
    Given I have browser opened and url is navigated
    And I have 2 products added in the cart	 
    When I delete one product from the cart
    Then cart should be updated accordingly
    

 @TC0041
 Scenario Outline: User should be able to Remove the items from Add To Cart list
    Given I have browser opened and url is navigated
    And I search for product as <name> and add it to cart
    And I click on Delete button
    Then I get message as "Your Amazon Basket is empty"
    
    Examples: 
      | name        |
      | Laptop      | 
      | Earphones   |    
     
   
      