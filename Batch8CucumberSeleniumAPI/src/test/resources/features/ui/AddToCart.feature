@ui @AddToCart
Feature: Add to cart functionality
   
   @TC0036
  Scenario: Add A Product To Cart and Validate cart window with product added	
    Given I have browser opened and url is navigated
    And I search for product as "Dell"
    When I click on any product in the Search Result and added to cart
    Then Count Of The Cart Should Be Displayed As 1
    And I click on Cart button then User Should Be Able To Navigate To Cart Window With The Product Added
      
 