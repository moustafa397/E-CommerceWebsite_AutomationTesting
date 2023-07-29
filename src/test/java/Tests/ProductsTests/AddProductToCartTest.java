package Tests.ProductsTests;

import Pages.HomePage;
import Pages.ProductPage;
import Pages.ShoppingCartPage;
import Tests.TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilties.JsonDataReader;

public class AddProductToCartTest extends TestBase {

    HomePage homePage;
    ProductPage productPage;
    ShoppingCartPage cartPage;
    JsonDataReader jsonReader;


    @BeforeClass
    public void getReady (){
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new ShoppingCartPage(driver);

        jsonReader = new JsonDataReader();
        jsonReader.readJsonFile();
    }

    @Test(priority = 1)
    public void SearchProductByAutoSuggest (){
        homePage.searchSuggestedProduct(jsonReader.searchText);
        Assert.assertTrue(productPage.getProductName().contains(jsonReader.searchText));
    }

    @Test(priority = 2)
    public void AddProductToCart(){

        SoftAssert softAssert = new SoftAssert();

        productPage.addProductToCart();
        softAssert.assertTrue(productPage.getSuccessMessage().contains(jsonReader.cartSuccessMessage));
        productPage.goToShoppingCart();
        softAssert.assertTrue(cartPage.getProductName().contains(jsonReader.productName));

        softAssert.assertAll();

    }

}

