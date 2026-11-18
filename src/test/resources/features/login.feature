Feature: SauceDemo Login

  Scenario: Successful login with valid credentials
    Given user is on the SauceDemo login page
    When user enters valid username and password
    And user clicks on the login button
    Then user should be navigated to the products page