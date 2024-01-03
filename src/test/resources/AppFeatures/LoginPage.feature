Feature: Login Page Feature
  Scenario: Login page title
    Given user is on login page
    When user gets title of page
    Then page title should be "Swag Labs"

  Scenario Outline: Login scenario with valid credentials
    Given user is on login page
    When User enters "<username>" and "<password>"
    And clicks on login button
    Then user gets title of page
    And page title should be "Swag Labs"
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | locked_out_user | secret_sauce |
      | problem_user | secret_sauce |
      | performance_glitch_user | secret_sauce |

    Scenario Outline: Login with invalid credentials
      Given user is on login page
      When User enters "<username>" and "<password>"
      And clicks on login button
      Then user should get error message "Epic sadface: Username and password do not match any user in this service"
      Examples:
        | username | password |
        | test     | test     |
        | test123  | test     |
        | 123      | 123      |



