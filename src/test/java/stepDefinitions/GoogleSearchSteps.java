package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.GoogleSearchPage;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleSearchSteps {

    private WebDriver driver = Hooks.getDriver();
    private GoogleSearchPage googleSearchPage;

    @Given("the user is on the Google search page")
    public void the_user_is_on_the_google_search_page() {
        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.openGoogleHomePage();
    }

    @When("the user searches for {string}")
    public void the_user_searches_for(String query) {
        googleSearchPage.searchFor(query);
    }

    @Then("the user clicks on the first link on the results page")
    public void the_user_clicks_on_the_first_link_on_the_results_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h3")));

        List<WebElement> searchResults = driver.findElements(By.cssSelector("h3"));
        if (!searchResults.isEmpty()) {
            searchResults.get(0).click();
        }

        // Increase the timeout duration and adjust the expected condition
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.titleContains("Gradle Build Tool"));
        } catch (TimeoutException e) {
            System.out.println("Current title: " + driver.getTitle());
            throw e;
        }

        assertTrue(driver.getTitle().toLowerCase().contains("gradle build tool"));
    }

    @Then("the search results page is displayed")
    public void the_search_results_page_is_displayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Google"));

        assertTrue(driver.getTitle().contains("Google"));
    }
}