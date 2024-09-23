Feature: Google Search

  Scenario: Search for a term on Google and click the first link
    Given the user is on the Google search page
    When the user searches for "gradle"
    Then the user clicks on the first link on the results page

  Scenario: Search for a term on Google
    Given the user is on the Google search page
    When the user searches for "Gradle"
    Then the search results page is displayed