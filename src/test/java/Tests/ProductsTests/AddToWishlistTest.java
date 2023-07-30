package Tests.ProductsTests;

import Pages.ProductPage;
import Tests.TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddToWishlistTest extends TestBase {

    ProductPage productPage;

    @Test(priority = 1)
    public void SearchProductByAutoSuggest (){
        productPage = homePage.searchSuggestedProduct(jsonReader.searchText);
        Assert.assertTrue(productPage.getProductName().contains(jsonReader.searchText));
    }

    @Test(priority = 2)
    public void AddProductToWishlist(){
        SoftAssert softAssert = new SoftAssert();

        productPage.addToWishlist();
        softAssert.assertTrue(productPage.getSuccessMessage().contains(jsonReader.wishlistSuccessMessage));
        var wishlistPage = productPage.goToWishlist();
        softAssert.assertTrue(wishlistPage.getProductName().contains(jsonReader.productName));

        softAssert.assertAll();

    }

}
