# Selenium / Cucumber example and template

Selenium is an open-source suite of tools primarily used for automating web browsers.

It provides a single interface that allows you to write test scripts in various programming languages like Java, Python, C#, Ruby, JavaScript, and more.

These scripts can then control browser behavior across different browser platforms.

## How to use

This repository contains some examples on using selenium / cucumber as well as normal unit tests/

### For basic tests

Refer to [GoogleSearchPageTest](src/test/java/pageObjects/GoogleSearchPageTest.java)

- Opens and searches for something on a google website using the chrome browser

### For Cucumber
Refer to [GoogleSearchSteps](src/test/java/stepDefinitions/GoogleSearchSteps.java) on the code to perform each action for given, when, then keywords.

Refer to [CucumberRunner](src/test/java/runners/CucumberRunner.java) on setting up the runner file

Refer to [google_search.feature](src/test/java/resources/google_search.feature) on gherkin example
