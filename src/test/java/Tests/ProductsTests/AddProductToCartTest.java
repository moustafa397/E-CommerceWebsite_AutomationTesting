package Tests.ProductsTests;

import Pages.ProductPage;
import Tests.TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddProductToCartTest extends TestBase {

    /*
    1- Get to a product by auto-suggestion search.
    2- Add a product to cart.
     */

    ProductPage productPage;


    @Test(priority = 1)
    public void SearchProductByAutoSuggest (){
        productPage = homePage.searchSuggestedProduct(jsonReader.searchText);
        Assert.assertTrue(productPage.getProductName().contains(jsonReader.searchText));
    }

    @Test(priority = 2)
    public void AddProductToCart(){

        SoftAssert softAssert = new SoftAssert();

        productPage.addProductToCart();
        softAssert.assertTrue(productPage.getSuccessMessage().contains(jsonReader.cartSuccessMessage));
        var cartPage = productPage.goToShoppingCart();
        softAssert.assertTrue(cartPage.getProductName().contains(jsonReader.productName));

        softAssert.assertAll();

    }

}

