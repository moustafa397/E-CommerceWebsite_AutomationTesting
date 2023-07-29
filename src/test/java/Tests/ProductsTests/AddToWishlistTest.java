package Tests.ProductsTests;

import Pages.HomePage;
import Pages.ProductPage;
import Pages.WishlistPage;
import Tests.TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilties.JsonDataReader;

public class AddToWishlistTest extends TestBase {

    HomePage homePage;
    ProductPage productPage;
    JsonDataReader jsonReader;
    WishlistPage wishlistPage;

    @BeforeClass
    public void getReady (){
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        wishlistPage= new WishlistPage(driver);


        jsonReader = new JsonDataReader();
        jsonReader.readJsonFile();
    }

    @Test(priority = 1)
    public void SearchProductByAutoSuggest (){
        homePage.searchSuggestedProduct(jsonReader.searchText);
        Assert.assertTrue(productPage.getProductName().contains(jsonReader.searchText));
    }

    @Test(priority = 2)
    public void AddProductToWishlist(){
        SoftAssert softAssert = new SoftAssert();

        productPage.addToWishlist();
        softAssert.assertTrue(productPage.getSuccessMessage().contains(jsonReader.wishlistSuccessMessage));
        productPage.goToWishlist();
        softAssert.assertTrue(wishlistPage.getProductName().contains(jsonReader.productName));

        softAssert.assertAll();

    }

}
