package solvd.com;

import org.testng.Assert;
import org.testng.annotations.Test;
import solvd.com.pages.HomePage;
import solvd.com.pages.SearchResults;

public class SearchProductTests extends AbstractTest {

    @Test()
    public void searchAProduct() {
        HomePage home = new HomePage(getDriver());
        SearchResults results = home.searchAProduct("abominable hoodie");

        Assert.assertEquals(results.getProductTitle(), "Abominable Hoodie");
    }
}
