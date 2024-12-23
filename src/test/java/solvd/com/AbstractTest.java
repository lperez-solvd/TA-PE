package solvd.com;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.net.URL;
import java.util.UUID;

public class AbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTest.class);

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    String url = "https://magento.softwaretestingboard.com";
    private String userEmail;  // Shared email for suite execution

    // URL of the Selenium Grid Hub
    private static final String HUB_URL = "http://localhost:4444/wd/hub";

    // Unique base for the email address
    private static final String EMAIL_BASE = "lucas" + UUID.randomUUID().toString().substring(0, 5); // To create a short unique part

    @BeforeSuite
    public void beforeSuite() {
        // Generate a unique email once per suite for both browsers
        LOGGER.info("Generated email base for the suite execution: {}", EMAIL_BASE);
    }

    @BeforeMethod
    @Parameters("browser")  // Use TestNG parameter to specify the browser
    public void setup(String browser) throws Exception {
        LOGGER.info("Starting driver for browser: {}", browser);

        // Generate browser-specific email
        String browserSpecificEmail = generateEmailForBrowser(browser);
        LOGGER.info("Generated email for browser {}: {}", browser, browserSpecificEmail);

        // Store the email to be used in the test methods
        this.userEmail = browserSpecificEmail;

        // DesiredCapabilities for Chrome and Firefox
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set up browser-specific options and capabilities
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            capabilities.setBrowserName("chrome");
            capabilities.merge(chromeOptions); // Merge chrome options with desired capabilities
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            capabilities.setBrowserName("firefox");
            capabilities.merge(firefoxOptions); // Merge firefox options with desired capabilities
        } else {
            throw new Exception("Browser not supported: " + browser);
        }

        // Initialize RemoteWebDriver with Selenium Grid Hub URL and desired capabilities
        driver.set(new RemoteWebDriver(new URL(HUB_URL), capabilities));

        LOGGER.info("Connecting driver to: {}", url);
        driver.get().get(url);
        LOGGER.info("Driver started in {} browser", browser);
    }

    // Generate a unique email for each browser
    private String generateEmailForBrowser(String browser) {
        // Append 'c' for Chrome and 'f' for Firefox to the base email
        if (browser.equalsIgnoreCase("chrome")) {
            return EMAIL_BASE + "c@google.com";
        } else if (browser.equalsIgnoreCase("firefox")) {
            return EMAIL_BASE + "f@google.com";
        } else {
            throw new IllegalArgumentException("Unknown browser: " + browser);
        }
    }

    @AfterMethod
    public void quitDriver() {
        WebDriver currentDriver = driver.get();
        if (currentDriver != null) {
            currentDriver.quit();
            LOGGER.info("Driver quit");
        }
        driver.remove();
    }

    // Getter for the email that is shared across the suite
    public String getUserEmail() {
        return userEmail;
    }

    public WebDriver getDriver() {
        return driver.get();
    }
}
