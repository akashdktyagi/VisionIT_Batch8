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

			