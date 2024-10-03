package pages;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxPage extends BasePageObject {
    private final By fullNameField = By.id("userName");
    private final By emailField = By.id("userEmail");
    private final By currentAddressField = By.id("currentAddress");
    private final By permanentAddressField = By.id("permanentAddress");
    private final By submitButton = By.id("submit");

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    public void openTextBoxPage() {
        openURL("https://demoqa.com/text-box");
    }

    public void fillTextBox(String fullName, String email, String currentAddress, String permanentAddress) {
        type(fullNameField, fullName);
        type(emailField, email);
        type(currentAddressField, currentAddress);
        type(permanentAddressField, permanentAddress);
    }

    public void clickSubmitButton() {
        click(submitButton);
    }

    public boolean isSubmittedInfoDisplayed(String fullName, String email, String currentAddress, String permanentAddress) {
        getText(By.cssSelector("p[id='name']"));
        //Use cssSelector to find the value first, else use xpath
        String displayedName = getText(By.cssSelector("p[id='name']"));
        String displayedEmail =getText(By.cssSelector("p[id='email']"));
        String displayedCurrentAddress = getText(By.cssSelector("p[id='currentAddress']"));
        String displayedPermanentAddress = getText(By.cssSelector("p[id='permanentAddress']"));

        return displayedName.contains(fullName) &&
                displayedEmail.contains(email) &&
                displayedCurrentAddress.contains(currentAddress) &&
                displayedPermanentAddress.contains(permanentAddress);
    }
}