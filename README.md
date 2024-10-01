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

## Learning

### Build.gradle
Purpose: This file defines the project's dependencies and build configurations.

Key Elements:
- Plugins: Includes plugins for Java and Cucumber.
- Repositories: Specifies where to download dependencies from (e.g., Maven Central).
- Dependencies: Lists all the libraries needed for the project, such as Selenium, WebDriverManager, JUnit, and Cucumber.
- Java Toolchain: Configures the Java version to be used.
- Test Configuration: Configures the test framework to use JUnit Platform.


### Settings.gradle
Purpose: This file defines the name of the root project.
Key Elements:
- Project Name: Sets the name of the project, which is useful for multi-project builds.

### CucumberRunner.java
Purpose: This class serves as the entry point for running the Cucumber tests.
Key Elements:
- Annotations: Uses JUnit Platform annotations to configure and run Cucumber tests.
- IncludeEngines: Specifies that the Cucumber engine should be used.
- SelectClasspathResource: Points to the directory containing feature files.
- ConfigurationParameter: Sets the glue parameter to specify the package containing step definitions and hooks.

### Google_search.feature
Purpose: These files define the test scenarios in Gherkin syntax.

Key Elements:
- Feature: Describes the feature under test.
- Scenario: Defines individual test cases with Given, When, and Then steps.
- Steps: Each step corresponds to a method in the step definitions.

### Hooks.java
Purpose: Manages the setup and teardown of the WebDriver.

Key Elements:
- @Before: Sets up the WebDriver before each scenario.
- @After: Quits the WebDriver after each scenario.
- getDriver: Provides access to the WebDriver instance for use in step definitions.


### GoogleSearchSteps.java
Purpose: Contains the step definitions that implement the steps defined in the feature files.

Key Elements:
- WebDriver: Uses the WebDriver instance from the Hooks class.
- Page Object: Interacts with the Google search page through a page object.
- Given, When, Then: Methods annotated with these keywords to match steps in the feature files.
- WebDriverWait: Waits for specific conditions to be met, such as elements being present or titles containing specific text.
- Assertions: Verifies the expected outcomes of the test steps.

### GoogleSearchPage.java
Purpose: Encapsulates interactions with the Google search page.

Key Elements:
- WebDriver: Uses the WebDriver to interact with the page.
- Methods: Contains methods to perform actions like opening the Google homepage and searching for a query.


### Working together
**Initialization:**

- The CucumberRunner class is executed, which reads the feature files and identifies the steps.
- The settings.gradle and build.gradle files ensure that all dependencies are available and the project is correctly configured.

**Test Execution:**

- For each scenario in the feature files, Cucumber matches the steps to the corresponding methods in the GoogleSearchSteps class.
- The Hooks class's @Before method sets up the WebDriver before the scenario runs.

**Step Execution:**

- The methods in GoogleSearchSteps interact with the web page using the WebDriver.
- The GoogleSearchPage class provides a clean interface for these interactions.

**Assertions and Validations:**

- The steps in GoogleSearchSteps contain assertions to validate the expected outcomes.
- If a step fails, the scenario is marked as failed.

**Teardown:**

- After each scenario, the Hooks class's @After method quits the WebDriver to ensure no resources are left hanging.