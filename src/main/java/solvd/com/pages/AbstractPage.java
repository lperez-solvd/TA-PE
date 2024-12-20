package solvd.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import solvd.com.Main;

import java.time.Duration;

public abstract class AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractPage.class);
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnElement(WebElement element) {
        // will wait until element is displayed to click it
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> element.isDisplayed());

        element.click();
    }

    public String getTextFromElement(WebElement element) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> element.isDisplayed());

        LOGGER.info("Text from {} will be used", element);

        return element.getText();
    }

    public void sendText(String text, WebElement element) {
        // will wait until element is displayed to click it
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> element.isDisplayed());
        element.sendKeys(text);
    }
}
