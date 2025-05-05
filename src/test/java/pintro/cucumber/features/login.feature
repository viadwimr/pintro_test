Feature: Login Functionality
  Scenario: Successful Login with valid credentials
    Given User is on Login Page
    When User enters valid username and password
    And User clicks the Login button
    Then User should be redirected to Dashboard
