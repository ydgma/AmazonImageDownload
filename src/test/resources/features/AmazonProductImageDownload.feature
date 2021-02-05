Feature: Downloading images from amazon

  #Scenario: Check that the user is able to successfully navigate to an amazon product page
  #  When I navigate to amazon home page
  #  And I search for "headphones"
  #  Then items of "headphones" are displayed

   Scenario: Check that images for a searched product are successfully downloaded 
     When I navigate to amazon home page
     And I search for "camera"
     And I click on the item number 2
     Then all images of the item are successfully downloaded

