# TODO - Create 1 scenario outline and create scenario or scenario outlines for page
# https://kristinek.github.io/site/tasks/list_of_people.html OR
# https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html

@Task2
Feature: Task 2 scenario outline
  As a test engineer
  I want to be able to write and execute scenaios and scenario outline
# in order to test that user can:
# - add a new person
# - edit a person
# - remove a person
# - reset original list after:
#   * adding a person
#   * editing a person
#   * removing a person
# - check that clear button on adding a user works correctly

  Scenario Outline: Task 2 scenario outline
    Given I am on people with jobs page
    Then I click add person button
    And I add a Name and Job
      |name|<name>|
      |job|<job>|

    And I click clear button
    And I check if fields are clear

    And I add a Name and Job
      |name|<name>|
      |job|<job>|

    Then I click the add button
    Then I check entered people
      |name|<name>|
      |job|<job>|
    Then I click edit button
#    And I edit a persons credentials
    Then I edit a job field: "Nope"
    Then I click edit confirm button
    Then I check changed person credentials "Nope"
#      |name|<name>|
#      |job|<job>|

    And I remove a person
    Then I check if i removed the person
    Then I reset the list
#

    Examples:

    |name|  job |
    |John|Tester|


    Scenario: task 2 scenario just because we need one
      Given I am on people with jobs page
      And I remove a person
      Then I check if i removed the person