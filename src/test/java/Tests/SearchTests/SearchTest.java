package Tests.SearchTests;


import Tests.TestBase.TestBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SearchTest extends TestBase {

    /*
    1-open browser.
    2-navigate to home page.
    3-enter product name in search text box and press search button.
    4-verify that search results related the searched text.
     */



    @Test
    public void searchProduct (){

        SoftAssert softAssert = new SoftAssert();
        var searchResultsPage = homePage.enterSearchText(jsonReader.searchText);
        List<String> productTexts = searchResultsPage.getProductsDisplayedTitle();
        for (String text : productTexts) {
            softAssert.assertTrue(text.contains(jsonReader.searchText));
        }
        softAssert.assertAll();
    }

}
