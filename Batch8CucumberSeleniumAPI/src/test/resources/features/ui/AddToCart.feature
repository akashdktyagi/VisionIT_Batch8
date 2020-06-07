@ui @AddToCart
Feature: Add to cart functionality

  @TC0036
  Scenario: Add A Product To Cart and Validate cart window with product added	
    Given I have browser opened and url is navigated
    And I search for product as "Dell"
    When I click on any product in the Search Result and added to cart
    Then Count Of The Cart Should Be Displayed As 1
    And I click on Cart button then User Should Be Able To Navigate To Cart Window With The Product Added     
    
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


  @TC0038
  Scenario: Validate the cart value in the header section is updated after adding product
	 Given I have browser opened and url is navigated
  	And I search for product as "Samsung"
  	And I get a text for cart
   	And  I click on any product in the Search result
   When   I click on Add to Cart button
   Then I am able to see the cart value gets updated in the header section
   
   
   	
	@TC0023
		Scenario: Verify after clicking on cart displayed in the header, the page is navigated to Shopping cart 
		Given I have browser opened and url is navigated
		When I search for product as "Dell"
		And I click on Add to Cart button 
		Then I click on cart button presesent in the header section
		And The Page Is Navigated To Shopping Cart 