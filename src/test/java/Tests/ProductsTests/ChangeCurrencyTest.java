package Tests.ProductsTests;

import Pages.HomePage;
import Pages.ProductPage;
import Tests.TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilties.JsonDataReader;

public class ChangeCurrencyTest extends TestBase {

    HomePage homePage;
    ProductPage productPage;
    JsonDataReader jsonReader;

    @BeforeClass
    public void getReady (){
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);

        jsonReader = new JsonDataReader();
        jsonReader.readJsonFile();
    }

    @Test(priority = 1)
    public void SearchProductByAutoSuggest (){
        homePage.searchSuggestedProduct(jsonReader.searchText);
        Assert.assertTrue(productPage.getProductName().contains(jsonReader.searchText));
    }


    @Test(priority = 2)
    public void verifyChangeCurrency(){
        productPage.changeCurrency(jsonReader.currencyValue);
        Assert.assertTrue(productPage.getProductPrice().contains(jsonReader.currencySymbol));
    }

}
