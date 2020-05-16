@ui @search
Feature: Search functionality


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
	  
	  
	  # Jira-3456
	  # Details: Search Functionaonliy-Epic-
	  #Story-Jira-1343-Search Via SeRCH TEXT BOX-5 test cases
	  #Story-Jira-4567: Search by Hamburger menu
	  #dfgfdggfdgdgd
	  