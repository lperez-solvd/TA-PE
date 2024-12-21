package solvd.com;

import org.testng.Assert;
import org.testng.annotations.Test;
import solvd.com.pages.HomePage;

public class DiscardProductTest extends AbstractTest {

    @Test
    public void addAndDiscardProduct() {

        HomePage home = new HomePage(getDriver());
        home.chooseSize();
        home.chooseColor();
        home.clickAddToCartButton();

        home.clickOnCart();

        // use an alternative wait because element loading process
        home.alternativeDeleteFirstElementInCart();

        home.acceptDeletion();

        Assert.assertEquals(home.getCartMessage(), "You have no items in your shopping cart.");


    }
}
