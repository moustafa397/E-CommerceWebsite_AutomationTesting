package Tests.ProductsTests;

import Pages.ProductPage;
import Pages.SearchPage;
import Pages.ShoppingCartPage;
import Pages.WishlistPage;
import Tests.TestBase.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddProductToCartTest extends TestBase {

    SearchPage searchPage;
    ProductPage productPage;
    ShoppingCartPage cartPage;

    @BeforeClass
    public void SearchProductByAutoSuggest (){
        searchPage = new SearchPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new ShoppingCartPage(driver);

        searchPage.searchSuggestedProduct("HTC");
    }

    @Test
    public void AddProductToWishlist(){

        SoftAssert softAssert = new SoftAssert();

        productPage.addProductToCart();
        softAssert.assertTrue(productPage.getSuccessMessage().contains("The product has been added to your shopping cart"));
        productPage.goToShoppingCart();
        softAssert.assertTrue(cartPage.getProductName().contains("HTC One M8 Android L 5.0 Lollipop"));

        softAssert.assertAll();

    }

}
