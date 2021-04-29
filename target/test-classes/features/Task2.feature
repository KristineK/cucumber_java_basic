@regression
Feature: Introduction to cucumber part 3
  As a test engineer
  I want to be able to write and execute a scenario outline

  @debugs
  Scenario Outline: add, edit, remove and reset
    Given I am on Employee page
    When click on Add person
    And fill all fields: "<name>", "<surname>", "<job>", "<DataEnter>", "<selectedCheck>", "<gender>", "<status>"
    And click button add
    And click on edit button
    And edit something: "<name1>", "<surname1>", "<job1>", "<DataEnter1>", "<selectedCheck1>", "<gender1>", "<status1>"
    And click on edit-button
    And remove a person
    Then reset list
    Examples:
      | name     | surname |     job           | DataEnter | selectedCheck | gender | status   |    name1    | surname1 |     job1      | DataEnter1 | selectedCheck1 | gender1 |     status1     |
      | Dmitrijs | Lvovs   | Quality Engineer  | 01/05/1999|    english    | male   | Employee |    Sergej   |  Orlov   |    QA         | 01/05/1999 |    french      |   male  |     Intern      |
      | Evgenij  | Orlov   | Quality Engineer  | 01/05/1979|    english    | male   | Employee |    Evgenij  |  Orlov   |    GameDev    | 01/05/1979 |    spanish     |   male  |     Employee    |
      | Ekaterina| Velika  | Team manager      | 04/07/2000|    french     | male   | Employee |    Ekaterina|  Velika  |    Team manager| 04/07/2000|    french      |   female|     Employee    |

  @debugs
  Scenario: check how working clear button
    Given I am on Employee page
    When click on Add person
    And fill all fields: "Ivan", "Kotcov", "Software developer", "02/09/1985", "spanish", "male", "Intern"
    And click clear-button
    Then check empty fields


