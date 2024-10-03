package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePageObject {

    private final WebDriver driver;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement find(By locator) {
        return this.driver.findElement(locator);
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void type(By locator, CharSequence... text) {
        find(locator).sendKeys(text);
    }

    public void openURL(String url) {
        this.driver.get(url);
    }

    public String getText(By locator) {
        return find(locator).getText();
    }

    public boolean isElementPresent(By locator) {
        try {
            return find(locator).isDisplayed();
        }catch (Exception e) {
            return false;
        }
    }
}

