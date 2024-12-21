package solvd.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResults extends AbstractPage {

    @FindBy(xpath = "//ol//li[1]//strong//a")
    WebElement firstProductTitle;

    public SearchResults(WebDriver driver) {
        super(driver);
    }

    public String getProductTitle() {
        return getTextFromElement(firstProductTitle);
    }
}
