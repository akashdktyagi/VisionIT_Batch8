@ui @search
Feature: Search functionality

	  @TC0001
    Scenario: Search a product 
    Given I have browser opened and url is navigated
    When I search for product as "Dell"
    Then product list should appear pertaining to the product search as "Dell"

    @TC0004
	  Scenario: User wants to search for Products using Hamburger menu in the Header Section
	  Given I have browser opened and url is navigated
	  When I click on hamburger menu
	  And I click on hamburger menu with category as "Mobiles, Computers"
	  And I click on hamburger menu with sub category as "Power Banks"
	  Then Search results are displayed for products related to "Power Banks"
	  
	  @TC0008 
	  Scenario: A User Should Be Able To Click On A Product Link From The Search Page And Product Description Page Should Be Displayed.
		Given I have browser opened and url is navigated
		When I search for product as "Dell"
		And I click on any product in the Search Result
		Then I am able to see product description and detail in new tab
		
	  @TC0017
		Scenario: A User entered any keyword in search then in Search dropdown it should display appropriate options which is entered in the Search.
	  Given I have browser opened and url is navigated
		When I entered product as "Dell" in search
		Then I am able to see autosuggestion options having keyword "Dell"
		
		@TC0040
		Scenario: Check The Subtotal Of Cart Is Correct
		Given I have browser opened and url is navigated
		When I Search Products and Added Into Cart
		Then The Subtotal Is Total Of All Products In Cart