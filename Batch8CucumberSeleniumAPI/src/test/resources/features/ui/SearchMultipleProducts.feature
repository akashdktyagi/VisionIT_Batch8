@ui @searchMultipleProducts
Feature: Search Mutiple Product Fuctionality
  I want to use this template for my feature file

  @TC0037
  Scenario: Search Mutiple Products
  
  Given I have browser opened and url is navigated
	When I search for and add single product <Product Name> of each category as below
			| Products                   |
      | Mobile                     |
      | Computer                   |
      | LED TV                     |
      | Pantry                     |
      | Kitchen                    |
      | toy train                  |
      | toy cars                   |
      | sport shoes for mens       |
      | gogless for boys           |
      | books in hindi best seller |
Then All the products should be added in the cart
   
    
