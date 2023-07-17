package Tests.SearchTests;

import Pages.SearchPage;
import Tests.TestBase.TestBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SearchTest extends TestBase {

    SearchPage searchPage;

    @Test
    public void searchProduct (){

        searchPage = new SearchPage(driver);
        SoftAssert softAssert = new SoftAssert();

        searchPage.enterSearchText("Apple");
        List<String> productTexts = searchPage.getProductsDisplayedTitle();
        for (String text : productTexts) {
            softAssert.assertTrue(text.contains("Apple"));
        }

        softAssert.assertAll();


    }

}
