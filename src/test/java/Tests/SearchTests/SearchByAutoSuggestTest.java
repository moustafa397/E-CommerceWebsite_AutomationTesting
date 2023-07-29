package Tests.SearchTests;

import Pages.HomePage;
import Pages.ProductPage;
import Tests.TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilties.JsonDataReader;

public class SearchByAutoSuggestTest extends TestBase {
    /*
    1-open browser.
    2-navigate to home page.
    3-enter product name in search text box and press on the first suggested product.
    4-verify that the product related to the searched text.
     */

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

    @Test
    public void SearchProductByAutoSuggest (){
        homePage.searchSuggestedProduct(jsonReader.searchText);
        Assert.assertTrue(productPage.getProductName().contains(jsonReader.searchText));
    }

}
