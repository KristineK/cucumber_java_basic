Feature: Validating a title of E-shop page
  As a test engineer
  I want to be able to validate a title on e-shop homepage

  Scenario: Simple scenario
    When I am on the shop page
    Then I should see shop page title

  Scenario: Verify both phone numbers on title page
    When I am on the shop page
    Then I should see shop page contact phone
    And I should see shop page bottom phone
