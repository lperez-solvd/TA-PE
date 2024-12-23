package solvd.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@title='Password']")
    WebElement passwordInput;

    @FindBy(xpath = "//button[@name='send'][1]")
    WebElement submitButton;

    public SignInPage(WebDriver driver) {
        super(driver);

    }


    public void enterEmail(String email) {
        sendText(email, emailInput);
    }

    public void enterPassword(String pass) {
        sendText(pass, passwordInput);
    }

    public SignInSuccessPage clickSubmitButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement spanElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.login")));

        clickOnElement(submitButton);
        return new SignInSuccessPage(driver);
    }


}
