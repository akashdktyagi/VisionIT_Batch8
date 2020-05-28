
@ui @searchMultipleProducts
Feature: Search Mutiple Product Fuctionality
  I want to use this template for my feature file

  @TC0037
  Scenario: Search Mutiple Products
  
    Given I have browser opened and url is navigated
    When I search Products
     |Products|
     |Mobile|
     |Computer|
     |LED TV|
     |Pantry|
     |Kitchen|
     |toy train|
     |toy cars|
     |sport shoes for mens|
     |gogless for boys|
     |books in hindi best seller|
     
    And Click on Search
     
    Then product list should appear pertaining to the product search as {string}
    |ProductsName|
    |Apple iPhone XR (64GB) - Blue|
    |Gandiva Desktop Computer (Core 2 Duo CPU / 4GB DDR2 Desktop RAM/No DVD Drive/USB Keyboard and Mouse / 15.6 Inch Monitor/WiFi Facility) with Windows 7 Trail Version Pre Installed (250GB HDD)|
    |DETEL 80 cm (32 Inches) DI32SF HD LED TV with 1 Year Warranty (Black) (2019 Model)|
    |Dabur Lal Tail 500ml – Ayurvedic Baby Oil 500 ml|
    |Butterfly Cordial Induction Base Non-Stick Aluminium Fry Pan, 24cm, Black|
    |Thomas & Friends Train Monkey Palace Set|
    |New Ray 1:24 Chevrolet Corvette Grand Sport 2010, Red|
    |Allout-04 Sports Shoes,Running Shoes,Gym Shoes for Men|
    |FIREBIRD WITH DEVICE Polarized Protected Aviator Black Sunglasses with TAC Material For Men Latest and For Women Stylish Wayfarer Sunglasses|
    |World’s Greatest Books For Personal Growth & Wealth (Set of 4 Books): Perfect Motivational Gift Set|
    
    
    Then I am able to see product description and detail in new tab
    Then Click on Add to Cart 
    Then Click on Proceed to Buy the products
    Then Page Nevigate to Login page
    Then Enter User Email Id or Phone
    Then Click on Continue 
    Then Enter Valid Password
    Then Click on Login Button
     
    
   
    
    