package solvd.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends AbstractPage {



    @FindBy(xpath = "//input[@name='firstname']")
    WebElement nameInput;

    @FindBy(xpath = "//input[@name='lastname']")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='email']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//input[@name='password_confirmation']")
    WebElement passwordConfirmation;

    @FindBy(xpath = "//button[@title='Create an Account']")
    WebElement submitButton;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }


    /*
     * Send text to inputs
     *
     * */
    public void enterName(String name) {
        sendText(name, nameInput);
    }

    public void enterLastName(String lastName) {
        sendText(lastName, lastNameInput);
    }

    public void enterEmail(String email) {
        sendText(email, emailInput);
    }

    public void enterPass(String password) {
        sendText(password, passwordInput);
        sendText(password, passwordConfirmation);
    }

    public CreateAccountSuccessPage clickSubmitButton() {
        clickOnElement(submitButton);
        return new CreateAccountSuccessPage(driver);
    }


}
