package Tests.ProductsTests;

import Pages.ProductPage;
import Tests.TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeCurrencyTest extends TestBase {
    ProductPage productPage;

    @Test(priority = 1)
    public void SearchProductByAutoSuggest (){
        productPage = homePage.searchSuggestedProduct(jsonReader.searchText);
        Assert.assertTrue(productPage.getProductName().contains(jsonReader.searchText));
    }


    @Test(priority = 2)
    public void verifyChangeCurrency(){
        productPage.changeCurrency(jsonReader.currencyValue);
        Assert.assertTrue(productPage.getProductPrice().contains(jsonReader.currencySymbol));
    }

}
