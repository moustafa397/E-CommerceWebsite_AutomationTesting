package Tests.SearchTests;

import Pages.ProductPage;
import Pages.SearchPage;
import Tests.TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchByAutoSuggestTest extends TestBase {

    SearchPage searchPage;
    ProductPage productPage;

    @Test
    public void SearchProductByAutoSuggest (){
        searchPage = new SearchPage(driver);
        productPage = new ProductPage(driver);

        searchPage.searchSuggestedProduct("HTC");
        Assert.assertTrue(productPage.getProductName().contains("HTC"));

    }

}
