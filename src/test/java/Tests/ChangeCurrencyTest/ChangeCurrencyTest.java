package Tests.ChangeCurrencyTest;

import Pages.HomePage;
import Pages.ProductPage;
import Pages.SearchPage;
import Tests.TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChangeCurrencyTest extends TestBase {

    HomePage homePage;
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
        productPage = new ProductPage(driver);

        productPage.changeCurrency("Euro");
        Assert.assertTrue(productPage.getProductPrice().contains(""));

    }

}
