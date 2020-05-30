@ui @AddToCart
Feature: Add to cart functionality
 
  @TC0032
  Scenario: User should be able to Remove the items from Add To Cart list
    Given I have browser opened and url is navigated
    And I search the products given below and add them to cart
         | Dell   |   
         | Mobile |  
    When I click on Cart
    And I click on Delete button for "Dell" Product
    Then I validate the Subtotal as 1 item 
    

 @TC0032
  Scenario Outline: User should be able to Remove the items from Add To Cart list
    Given I have browser opened and url is navigated
    And I search for product as <name> and add it to cart
    When I click on Cart
    And I click on Delete button
    Then I get message as "Your Amazon cart is empty"
    
    Examples: 
      | name   | 
      | Dell   |   
      | Mobile |  	
      
   
      