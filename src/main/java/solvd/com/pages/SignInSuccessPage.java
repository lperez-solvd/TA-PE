package solvd.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInSuccessPage extends AbstractPage {

    WebDriver driver;

    @FindBy(xpath = "//div[@class='box-content']//p")
    WebElement boxContent;
    @FindBy(xpath = "//ul//li//span[contains(text(),'Welcome')]")
    WebElement welcomeMessage;

    public SignInSuccessPage(WebDriver driver) {
        super(driver);

    }


    public String getBoxText() {
        return getTextFromElement(boxContent);
    }

    public String getWelcomeMessage() {
        return getTextFromElement(welcomeMessage);
    }

}
