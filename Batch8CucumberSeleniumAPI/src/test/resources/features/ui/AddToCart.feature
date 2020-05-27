@ui @AddToCart
Feature: Add to cart functionality
 
  @TC0032
  Scenario: User should be able to Remove the items from Add To Cart list
    Given I have browser opened and url is navigated
    When I search for product as "Dell"
    And I click on any product in the Search Result
    And I click on Add to Cart button
    And I search for product as "Mobile"
    And I click on any product in the Search Result
    And I click on Add to Cart button
    Then I click on Cart
    And I click on Delete button for "Dell" Product
    And I validate the Subtotal as 1 item 
    

 @TC0032
  Scenario Outline: User should be able to Remove the items from Add To Cart list
    Given I have browser opened and url is navigated
    When I search for product as <name>
    And I click on any product in the Search Result
    And I click on Add to Cart button
    Then I click on Cart
    And I click on Delete button
    And I get message as "Your Amazon cart is empty"
    
    Examples: 
      | name   | 
      | Dell   |   
      | Mobile |  	
      
   
      