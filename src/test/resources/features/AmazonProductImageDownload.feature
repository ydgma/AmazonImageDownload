Feature: Downloading images from amazon

  Scenario: Check that the user is able to successfully navigate to an amazon product page
    When I navigate to amazon home page
    And I search for "headphones"
