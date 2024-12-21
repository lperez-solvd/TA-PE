package solvd.com;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;


import java.util.UUID;

public class AbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTest.class);

    WebDriver driver;
    String url = "https://magento.softwaretestingboard.com";
    private static String userEmail = "lperez119946@google.com";

    @BeforeSuite
    public void generateUniqueEmail() {
        // Generate a unique email using UUID and append it to the domain
        userEmail = "user" + UUID.randomUUID() + "@google.com";
        LOGGER.info("Generated unique email for this suite execution: {}", userEmail);
    }

    public String getUserEmail() {
        return userEmail;
    }

    @BeforeMethod
    public void setup() {
        LOGGER.info("Starting driver");
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/Users/solvd/Desktop/chromedriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
        LOGGER.info("Connecting chromedriver to: {}", url);
        driver.get(url);
        LOGGER.info("Driver started");
    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
