package pageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleTest {

    @Test
    public void openGooglePage(){
        //webdriver to setup chromedriver
        WebDriverManager.chromedriver().setup();
        //initialize browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        WebElement inputSearch = driver.findElement(By.name("q"));
        inputSearch.sendKeys("Selenium ChromeDriver" + Keys.ENTER);

        //wait for 5 sec
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
