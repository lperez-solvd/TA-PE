package solvd.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountSuccessPage {
    WebDriver driver;

    @FindBy(xpath = "//div[@role='alert']")
    WebElement alertMessage;

    public CreateAccountSuccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getAlertMessage() {
        return alertMessage.getText();
    }


}
