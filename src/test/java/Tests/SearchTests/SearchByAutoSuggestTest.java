package Tests.SearchTests;

import Tests.TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchByAutoSuggestTest extends TestBase {
    /*
    1-open browser.
    2-navigate to home page.
    3-enter product name in search text box and press on the first suggested product.
    4-verify that the product related to the searched text.
     */



    @Test
    public void SearchProductByAutoSuggest (){
        var productPage = homePage.searchSuggestedProduct(jsonReader.searchText);
        Assert.assertTrue(productPage.getProductName().contains(jsonReader.searchText));
    }

}
