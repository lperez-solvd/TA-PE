package solvd.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Create an Account')]")
    WebElement createAccountButton;

    @FindBy(xpath = "//a[contains(text(),'Sign In')]")
    WebElement signInButton;
    @FindBy(xpath = "//div[@class='block-content']//ol//li[1]//div[@option-id='166']")
    WebElement firstHotSellersSize;
    @FindBy(xpath = "//div[@class='block-content']//ol//li[1]//div[@option-id='56']")
    WebElement firstHotSellersColor;
    @FindBy(xpath = "//div[@class='block-content']//ol//li[1]//button[@type='submit']")
    WebElement firstHotSellersAddButton;
    @FindBy(xpath = "//div[@class='block-content']//ol//li[1]//button[@type='submit']")
    WebElement cartElementsCounter;
    @FindBy(xpath = "//ol[@id='mini-cart']//li[1]//a[@title='Remove item']")
    WebElement firstElementInCartDeleteButton;
    @FindBy(xpath = "//aside[@role='dialog']//footer//button[contains(span,'OK')]")
    WebElement acceptDeletionButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    public void clickSingInButton() {
        signInButton.click();
    }

    public void chooseSize() {
        firstHotSellersSize.click();
    }

    public void chooseColor() {
        firstHotSellersColor.click();
    }

    public void clickAddToCartButton() {
        firstHotSellersAddButton.click();
    }

    public String getNumberOfElementsInCart() {
        return cartElementsCounter.getText();
    }

    public void deleteFirstElementInCart() {
        firstElementInCartDeleteButton.click();
    }

    public void acceptDeletion() {
        acceptDeletionButton.click();
    }
}
