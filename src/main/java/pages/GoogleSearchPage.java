package pages;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage extends BasePageObject {

    private WebDriver driver;
    private By searchBox = By.name("q");

    // Constructor to initialize the WebDriver
    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    // Method to open Google homepage
    public void openGoogleHomePage() {
        openURL("https://www.google.com");
    }

    // Method to search for a query
    public void searchFor(String query) {
        type(searchBox, query + Keys.ENTER);
    }
}