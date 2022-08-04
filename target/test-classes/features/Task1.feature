
# TODO - Create 1 scenario outline and 1 scenario for page with url: "https://kristinek.github.io/site/tasks/enter_a_number"
# - Scenario outline for error cases. One example for each case:
#   * enter number too small
#   * enter number too big
#   * enter text instead of the number
# - Scenario for correct number

Feature: Task 1 feature
  As a test engineer
  I want to be able to write and execute different scenarios



  Scenario Outline:
    Given I am on the page
    When I enter <in>
    Then I click submit button
    Then I have <error msg>

    Examples:
      |in|error msg|
      |11    |Number is too small|
      |111   |Number is too big  |
      |Text |Please enter a number|

  Scenario: Correct number
    Given I am on the Enter a number page
    When I enter number: "81"
    And I click on Submit button
   Then I see the result message "Square root of 81 is 9.00"
