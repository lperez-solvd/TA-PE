package solvd.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import solvd.com.pages.AbstractPage;

public class AbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTest.class);

    WebDriver driver;
    String url = "https://magento.softwaretestingboard.com";

    @BeforeTest
    public void setup() {
        LOGGER.info("Starting driver");
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/Users/solvd/Desktop/chromedriver/chromedriver");
        driver = new ChromeDriver();
        LOGGER.info("Connecting chromedriver to: {}", url);
        driver.get(url);
        LOGGER.info("Driver started");
    }

    @AfterTest
    public void quitDriver() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
