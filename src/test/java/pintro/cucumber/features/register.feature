Feature: Enroll Form Submission
  Scenario: Successful form submission with valid data
    Given User is on the Enroll Page
    When User fills out the form with valid data
    And User submits the form
    Then User should see a confirmation message
