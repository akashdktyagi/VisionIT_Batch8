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
	   
	  @TC0006
	  Scenario: User should be able to search for product after entering any keyword in SearchBox and then hover on Sub-Navigation list.
		Given I have browser opened and url is navigated
		When In SearchBox search for product as "Dell" 
		And In Sub Navigation List click on 'Mobile And Accessories'
		And Click On Brand As 'Apple'.
		Then Search Should Display Results With Apple Products.
