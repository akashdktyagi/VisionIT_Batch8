@ui @searchMultipleProducts
Feature: Search Mutiple Product Fuctionality
  I want to use this template for my feature file

  @TC0037
  Scenario: Search Mutiple Products
    Given I have browser opened and url is navigated
    When I search Product and click on Search Button
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
    And I Select product from the list and click on it
      | ProductsName                                                                                                                                                                                  |
      | Apple iPhone XR (64GB) - Blue                                                                                                                                                                 |
      | Gandiva Desktop Computer (Core 2 Duo CPU / 4GB DDR2 Desktop RAM/No DVD Drive/USB Keyboard and Mouse / 15.6 Inch Monitor/WiFi Facility) with Windows 7 Trail Version Pre Installed (250GB HDD) |
      | DETEL 80 cm (32 Inches) DI32SF HD LED TV with 1 Year Warranty (Black) (2019 Model)                                                                                                            |
      | Dabur Lal Tail 500ml – Ayurvedic Baby Oil 500 ml                                                                                                                                              |
      | Butterfly Cordial Induction Base Non-Stick Aluminium Fry Pan, 24cm, Black                                                                                                                     |
      | Thomas & Friends Train Monkey Palace Set                                                                                                                                                      |
      | New Ray 1:24 Chevrolet Corvette Grand Sport 2010, Red                                                                                                                                         |
      | Allout-04 Sports Shoes,Running Shoes,Gym Shoes for Men                                                                                                                                        |
      | FIREBIRD WITH DEVICE Polarized Protected Aviator Black Sunglasses with TAC Material For Men Latest and For Women Stylish Wayfarer Sunglasses                                                  |
      | World’s Greatest Books For Personal Growth & Wealth (Set of 4 Books): Perfect Motivational Gift Set                                                                                           |
    Then Page is nevigating to new window 
    Then I Validate product description and detail
    Then I Click on Add to Cart
    Then I Click on cart and Processed to Buy Products
    
