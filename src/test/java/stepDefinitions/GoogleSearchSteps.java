package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleSearchSteps {

    private WebDriver driver;
    private GoogleSearchPage googleSearchPage;

    @Given("the user is on the Google search page")
    public void the_user_is_on_the_google_search_page() {
        System.out.println("Setting up ChromeDriver...");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.openGoogleHomePage();
        System.out.println("ChromeDriver setup complete. Navigated to Google search page.");
    }

    @When("the user searches for {string}")
    public void the_user_searches_for(String query) {
        googleSearchPage.searchFor(query);
    }

    @Then("the user clicks on the first link on the results page")
    public void the_user_clicks_on_the_first_link_on_the_results_page() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<WebElement> searchResults = driver.findElements(By.cssSelector("h3"));
        if (!searchResults.isEmpty()) {
            searchResults.get(0).click();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertTrue(driver.getTitle().toLowerCase().contains("gradle"));

        driver.quit();
    }

    @Then("the search results page is displayed")
    public void the_search_results_page_is_displayed() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        assertTrue(driver.getTitle().contains("Google"));

        driver.quit();
    }
}