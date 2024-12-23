package solvd.com.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    // Method to capture a screenshot
    public static void captureScreenshot(WebDriver driver, String screenshotName) throws IOException {
        // Cast driver to TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        // Capture screenshot and store it in a File
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);

        // Define the path where the screenshot will be saved
        String filePath = System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png";

        // Save the screenshot to the defined file path
        File destinationFile = new File(filePath);
        FileUtils.copyFile(screenshotFile, destinationFile);

        System.out.println("Screenshot captured and saved at: " + filePath);
    }
}
