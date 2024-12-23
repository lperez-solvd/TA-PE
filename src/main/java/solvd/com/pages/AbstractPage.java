package solvd.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public abstract class AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractPage.class);
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnElement(WebElement element) {

        String browser = driver.getClass().getSimpleName().toLowerCase();
        LOGGER.info(browser);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));  // Wait until element is clickable


        element.click();
    }

    public String getTextFromElement(WebElement element) {
        // Set up the WebDriverWait with a timeout
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the WebElement to be clickable using a lambda expression
        wait.until(d -> element.isEnabled() && element.isDisplayed());

        LOGGER.info("Text from element: {}", element.getText());

        return element.getText();
    }

    public void sendText(String text, WebElement element) {
        // will wait until element is displayed to click it
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> element.isDisplayed());
        element.sendKeys(text);
    }
}
