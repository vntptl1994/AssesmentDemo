Feature: Home Page feature
  Background:
    Given User is already on logged in to application
      | username      | password     |
      | standard_user | secret_sauce |

    Scenario: Home page title
      Given User is on home page
      When user gets title of page
      Then page title should be "Swag Labs"

      Scenario: Product add to cart
        Given User is on home page
        When click on add to cart button
        And click on cart image
        And user clicks on checkout button
        When user enters "<firstname>" "<lastname>" and "<postalcode>"
        Then user clicks on continue
        When user clicks on finish button
        Then message should be displayed "Thank you"

