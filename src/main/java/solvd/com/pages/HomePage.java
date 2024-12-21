package solvd.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage extends AbstractPage {

    @FindBy(xpath = "//a[contains(text(),'Create an Account')]")
    WebElement createAccountButton;

    @FindBy(xpath = "//a[contains(text(),'Sign In')]")
    WebElement signInButton;
    @FindBy(xpath = "//ol//li[1]//div[@id='option-label-size-143-item-167']")
    WebElement firstHotSellersSize;
    @FindBy(xpath = "//ol//li[1]//div[@id='option-label-color-93-item-56']")
    WebElement firstHotSellersColor;
    @FindBy(xpath = "//div[@class='block-content']//ol//li[1]//button[@type='submit']")
    WebElement firstHotSellersAddButton;
    @FindBy(xpath = "//span[@class='counter-number']")
    WebElement cartElementsCounter;
    @FindBy(xpath = "//ol[@id='mini-cart']//li[1]//a[@title='Remove item']")
    WebElement firstElementInCartDeleteButton;
    @FindBy(xpath = "//aside[@role='dialog']//footer//button[contains(span,'OK')]")
    WebElement acceptDeletionButton;
    @FindBy(xpath = "//div[@id='ui-id-1']//strong[@class]")
    WebElement cartMessage;
    @FindBy(id = "search")
    WebElement searchInput;
    @FindBy(xpath = "//form[@id='search_mini_form']//button")
    WebElement searchButton;
    @FindBy(xpath = "//div[@data-block='minicart']//a//span[@class='text']/..")
    WebElement openCartButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }




    public CreateAccountPage clickCreateAccountButton() {
        clickOnElement(createAccountButton);
        return new CreateAccountPage(driver);
    }

    public SignInPage clickSingInButton() {
        signInButton.click();
        return new SignInPage(driver);
    }

    public void chooseSize() {
        clickOnElement(firstHotSellersSize);
    }

    public void chooseColor() {
        clickOnElement(firstHotSellersColor);
    }

    public void clickAddToCartButton() {
        clickOnElement(firstHotSellersAddButton);
    }

    public String getNumberOfElementsInCart() {
        return getTextFromElement(cartElementsCounter);
    }

    public void clickOnCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement spanElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.counter.qty")));
        clickOnElement(openCartButton);
    }

    public void deleteFirstElementInCart() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> firstElementInCartDeleteButton.isEnabled());
        clickOnElement(firstElementInCartDeleteButton);
    }

    public void alternativeDeleteFirstElementInCart() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.action.delete")));
        element.click();
    }

    public void acceptDeletion() {
        clickOnElement(acceptDeletionButton);
    }

    public String getCartMessage() {
        return getTextFromElement(cartMessage);
    }

    public SearchResults searchAProduct(String product) {
        sendText(product, searchInput);
        clickOnElement(searchButton);
        return new SearchResults(driver);
    }


}
