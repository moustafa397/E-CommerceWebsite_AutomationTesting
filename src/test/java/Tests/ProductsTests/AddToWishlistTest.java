package Tests.ProductsTests;

import Pages.ProductPage;
import Pages.SearchPage;
import Pages.WishlistPage;
import Tests.TestBase.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddToWishlistTest extends TestBase {

    SearchPage searchPage;
    ProductPage productPage;
    WishlistPage wishlistPage;

    @BeforeClass
    public void SearchProductByAutoSuggest (){
        searchPage = new SearchPage(driver);

        searchPage.searchSuggestedProduct("HTC");
    }

    @Test
    public void AddProductToWishlist(){
        productPage = new ProductPage(driver);
        wishlistPage= new WishlistPage(driver);
        SoftAssert softAssert = new SoftAssert();

        productPage.addToWishlist();
        softAssert.assertTrue(productPage.getSuccessMessage().contains("The product has been added to your wishlist"));
        productPage.goToWishlist();
        softAssert.assertTrue(wishlistPage.getProductName().contains("HTC One M8 Android L 5.0 Lollipop"));

        softAssert.assertAll();

    }

}
