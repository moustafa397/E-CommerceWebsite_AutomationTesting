package Tests.SearchTests;

import Pages.HomePage;
import Pages.SearchResultsPage;
import Tests.TestBase.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilties.JsonDataReader;

import java.util.List;

public class SearchTest extends TestBase {

    /*
    1-open browser.
    2-navigate to home page.
    3-enter product name in search text box and press search button.
    4-verify that search results related the searched text.
     */

    HomePage home;
    SearchResultsPage searchResultsPage;
    JsonDataReader jsonReader;


    @BeforeClass
    public void getReady (){
        home = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);

        jsonReader = new JsonDataReader();
        jsonReader.readJsonFile();

    }

    @Test
    public void searchProduct (){


        SoftAssert softAssert = new SoftAssert();
        home.enterSearchText(jsonReader.searchText);
        List<String> productTexts = searchResultsPage.getProductsDisplayedTitle();
        for (String text : productTexts) {
            softAssert.assertTrue(text.contains(jsonReader.searchText));
        }
        softAssert.assertAll();
    }

}
