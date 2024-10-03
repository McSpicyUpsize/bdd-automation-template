Feature: Text Box Form

  Scenario: Fill in the text box form and validate the results
    Given the user is on the text box page
    When the user fills in the text boxes
    And the user clicks the submit button
    Then the user should see the submitted information