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
	
		
	@TC0025
  Scenario: Verify That The User Is Able To Log In To The Application With Valid Email Id And Valid Password
    Given Enter url and page is navigated to Login page
    When  user enter valid Email_Id and Password
    Then user  is succesfully  login  to page
   
 	