package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.TextBoxPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextBoxSteps {

    private WebDriver driver = Hooks.getDriver();
    private TextBoxPage textBoxPage;

    @Given("the user is on the text box page")
    public void the_user_is_on_the_text_box_page() {
        textBoxPage = new TextBoxPage(driver);
        textBoxPage.openTextBoxPage();
    }

    @When("the user fills in the text boxes")
    public void the_user_fills_in_the_text_boxes() {
        textBoxPage.fillTextBox("TestName", "TestEmail@email.com", "123 Main St", "456 Elm St");
    }

    @When("the user clicks the submit button")
    public void the_user_clicks_the_submit_button() {
        textBoxPage.clickSubmitButton();
    }

    @Then("the user should see the submitted information")
    public void the_user_should_see_the_submitted_information() {
        assertTrue(textBoxPage.isSubmittedInfoDisplayed("TestName", "TestEmail@email.com", "123 Main St", "456 Elm St"));
    }
}