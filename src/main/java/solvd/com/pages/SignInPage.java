package solvd.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@title='Password']")
    WebElement passwordInput;

    @FindBy(xpath = "//button[@name='send']")
    WebElement submitButton;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterText(String text, WebElement element) {
        element.sendKeys(text);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }


}
