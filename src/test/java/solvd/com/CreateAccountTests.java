package solvd.com;

import org.testng.Assert;
import org.testng.annotations.Test;
import solvd.com.pages.CreateAccountPage;
import solvd.com.pages.CreateAccountSuccessPage;
import solvd.com.pages.HomePage;


public class CreateAccountTests extends AbstractTest {

    @Test
    public void createAccount() {

        HomePage home = new HomePage(getDriver());
        CreateAccountPage create = home.clickCreateAccountButton();

        create.enterName("Lucas");
        create.enterLastName("Perez");
        create.enterEmail(getUserEmail());
        create.enterPass("1LuPoIo4");

        CreateAccountSuccessPage createSuccess = create.clickSubmitButton();

        Assert.assertEquals(createSuccess.getAlertMessage(), "Thank you for registering with Main Website Store.");

    }

    @Test(dependsOnMethods = {"createAccount"})
    public void createAccountWithExistingEmail() {
        HomePage home = new HomePage(getDriver());
        CreateAccountPage create = home.clickCreateAccountButton();

        create.enterName("Lucas");
        create.enterLastName("Perez");
        create.enterEmail(getUserEmail());
        create.enterPass("1LuPoIo4");

        CreateAccountSuccessPage createSuccess = create.clickSubmitButton();

        Assert.assertEquals(createSuccess.getAlertMessage(), "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.");
    }

}
