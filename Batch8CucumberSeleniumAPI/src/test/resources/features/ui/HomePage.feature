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
			
			
	
	@TC0034
	Scenario: Mouse Hover
	  Given I have browser opened and url is navigated
		When I move mouse over the header link accounts 
		Then pop window should appear