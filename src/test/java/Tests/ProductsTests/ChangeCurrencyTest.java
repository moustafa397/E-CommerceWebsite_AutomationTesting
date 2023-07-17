package Tests.ProductsTests;

import Pages.ProductPage;
import Pages.SearchPage;
import Tests.TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChangeCurrencyTest extends TestBase {

    SearchPage searchPage;
    ProductPage productPage;

    @BeforeClass
    public void SearchProductByAutoSuggest (){
        searchPage = new SearchPage(driver);
        productPage = new ProductPage(driver);

        searchPage.searchSuggestedProduct("HTC");
    }


    @Test
    public void verifyChangeCurrency(){
        productPage.changeCurrency("Euro");
        Assert.assertTrue(productPage.getProductPrice().contains("€"));
    }

}
