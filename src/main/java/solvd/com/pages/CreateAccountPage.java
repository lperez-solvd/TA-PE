package solvd.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {

    WebDriver driver;
    @FindBy(id = "form-validate")
    WebElement registerForm;

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
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getRegisterForm() {
        return registerForm;
    }

    public WebElement getNameInput() {
        return nameInput;
    }

    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    /*
     * Send text to inputs
     *
     * */
    public void enterText(String name, WebElement element) {
        element.sendKeys(name);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }


}
