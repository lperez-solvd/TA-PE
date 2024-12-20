package solvd.com;

import org.testng.Assert;
import org.testng.annotations.Test;
import solvd.com.pages.CreateAccountPage;
import solvd.com.pages.CreateAccountSuccessPage;
import solvd.com.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateAccountTest extends AbstractTest {

    @Test
    public void createAccount() {


        HomePage home = new HomePage(getDriver());
        CreateAccountPage create = home.clickCreateAccountButton();

        create.enterName("Lucas");
        create.enterLastName("Perez");
        create.enterEmail("lperez222@google.com");
        create.enterPass("1LuPoIo4");

        CreateAccountSuccessPage createSuccess = create.clickSubmitButton();

        Assert.assertEquals(createSuccess.getAlertMessage(), "Thank you for registering with Main Website Store.");

    }

}
