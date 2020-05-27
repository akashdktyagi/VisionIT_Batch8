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
	  
	  
	  @TC0028
	  Scenario: Verify Pagination On Product Search Page
		Given I have browser opened and url is navigated
		When I search for product as "Dell"
		And I check when user is on the first page not able to click on the previous button
		And User is able click to the next button when user has already navigated to any other page or on the first page
	  And User Should not be able to click on the Next button when the user is on the last page
	  Then User is able to the previous button when the user has already navigated to any other page or on the last page
	 