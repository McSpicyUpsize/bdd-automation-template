package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {

    private WebDriver driver;
    private By searchBox = By.name("q");

    // Constructor to initialize the WebDriver
    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to open Google homepage
    public void openGoogleHomePage() {
        driver.get("https://www.google.com");
    }

    // Method to search for a query
    public void searchFor(String query) {
        WebElement inputSearch = driver.findElement(searchBox);
        inputSearch.sendKeys(query + Keys.ENTER);
    }
}