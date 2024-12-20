package solvd.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import solvd.com.pages.*;

import java.time.Duration;

public class SignInTest extends AbstractTest {

    @Test
    public void signInWithCorrectCredentials() {
        // Set the path to the ChromeDriver executable

        HomePage home = new HomePage(getDriver());
        SignInPage signin = home.clickSingInButton();
        signin.enterEmail("lperez22@google.com");
        signin.enterPassword("1LuPoIo4");

        SignInSuccessPage signinSuccess = signin.clickSubmitButton();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Assert.assertTrue(signinSuccess.getWelcomeMessage().contains("Lucas Perez"));

    }
}
