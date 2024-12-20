package solvd.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;
import solvd.com.pages.HomePage;


public class AddProductTest extends AbstractTest{


    @Test
    public void addProductToCart() {

        HomePage home = new HomePage(getDriver());
        home.chooseSize();
        home.chooseColor();
        home.clickAddToCartButton();

        Assert.assertEquals(home.getNumberOfElementsInCart(), "1");
    }
}
