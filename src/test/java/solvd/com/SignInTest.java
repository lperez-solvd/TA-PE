package solvd.com;

import org.testng.Assert;
import org.testng.annotations.Test;
import solvd.com.pages.*;


public class SignInTest extends AbstractTest {

    @Test()
    public void signInWithCorrectCredentials() {
        // Set the path to the ChromeDriver executable

        HomePage home = new HomePage(getDriver());
        SignInPage signin = home.clickSingInButton();
        signin.enterEmail(getUserEmail());
        signin.enterPassword("1LuPoIo4");

        SignInSuccessPage signinSuccess = signin.clickSubmitButton();

        Assert.assertTrue(signinSuccess.getWelcomeMessage().contains("Lucas Perez"));

    }
}
