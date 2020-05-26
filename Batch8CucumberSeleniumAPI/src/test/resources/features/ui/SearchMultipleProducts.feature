
@ui @searchMultipleProducts
Feature: Search Mutiple Product Fuctionality
  I want to use this template for my feature file

  @TC0037
  Scenario: Search Mutiple Products
    Given I have browser opened and url is navigated
    When I search and add products
    |Product Name|
    |Apple iPhone XR (64GB) - White|
    |Gandiva Desktop Computer PC (Core i5 1st Generation CPU / 8GB DDR3 RAM / 18.5 Inch LED Monitor/USB Keyboard & Mouse/WiFi) Pre Installed Windows 10 Professional (Trail Version) (500GB Hard Drive)|
    |The Power of Your Subconscious Mind (DELUXE HARDBOUND EDITION)|
    |First Trimester Ultrasound Diagnosis of Fetal Abnormalities|
    
    When I Check Out
