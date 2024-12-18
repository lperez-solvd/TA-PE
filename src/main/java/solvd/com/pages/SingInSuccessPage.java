package solvd.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingInSuccessPage {

    WebDriver driver;

    @FindBy(xpath = "//div[@class='box-content']//p")
    WebElement boxContent;

    public SingInSuccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getBoxText() {
        return boxContent.getText();
    }

}
