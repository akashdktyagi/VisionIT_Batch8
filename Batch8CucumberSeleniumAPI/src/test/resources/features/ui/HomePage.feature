@ui
Feature: Home Page Validation

	@TC0003
	Scenario: Validate Header links
	  Given I have browser opened and url is navigated
		Then Below header Links are displayed
			|hamburger menu   |
			|amazon prime logo|
			|accounts and list link|
			|return and orders|
			|your prime link|
			|cart link|
	
		@TC0024
		Scenario: Validate Accounts and Links Fly Out Pop Up
	  Given I have browser opened and url is navigated
		When I move mouse on the "Accounts and Links"
		And I click on "Your Account" Link in the Accounts and Links Fly Out Pop up
		Then I navigate to "Your Account" Page
		
		@TC0021
		Scenario: User should be able to navigate to the products present in the HomePage
	  Given I have browser opened and url is navigated
		And I click on "Grocery essentials"
		When I click on any product in the list
	  Then I am able to see product description and details
	  
	  
	   