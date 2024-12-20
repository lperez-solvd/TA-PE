package solvd.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountSuccessPage extends AbstractPage {

    @FindBy(xpath = "//div[@role='alert']")
    WebElement alertMessage;

    public CreateAccountSuccessPage(WebDriver driver) {
        super(driver);

    }


    public String getAlertMessage() {
        return getTextFromElement(alertMessage);
    }


}
