package solvd.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInSuccessPage extends AbstractPage {



    @FindBy(xpath = "//ul//li//span[contains(text(),'Welcome')]")
    WebElement welcomeMessage;

    public SignInSuccessPage(WebDriver driver) {
        super(driver);
    }



    public String getWelcomeMessage() {
        return getTextFromElement(welcomeMessage);
    }

}
