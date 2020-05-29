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
    
   @TC0036
  Scenario: Add A Product To Cart and Validate cart window with product added	
    Given I have browser opened and url is navigated
    When I search for product as "Dell"
    And I click on any product in the Search Result
    And I click on Add to Cart button
    Then Count Of The Cart Should Be Displayed As 1
    And I click on Cart
    And User Should Be Able To Navigate To Cart Window With The Product Added
      
   