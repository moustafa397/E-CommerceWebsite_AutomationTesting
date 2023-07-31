package Tests.ProductsTests;

import Pages.*;
import Tests.TestBase.TestBase;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegisteredUserCheckoutTest extends TestBase {

    /*
    1- User register.
    2- User log in.
    3- Get to a product by auto-suggestion search.
    4- Add a product to cart.
    5- Make checkout and confirm the order.
     */

    ProductPage productPage;
    ShoppingCartPage cartPage;
    String email;

    @BeforeClass
    public void getReady() {
        //generate an email for register.
        Faker fakeData = new Faker();
        email = fakeData.internet().emailAddress();
    }

    @Test(priority = 1)
    public void UserRegisterSuccessfully() {
        var registerPage = homePage.openRegisterPage();
        registerPage.userRegistration(jsonReader.firstName, jsonReader.lastName, email, jsonReader.password);
        Assert.assertTrue(registerPage.getSuccessMessage().contains(jsonReader.successRegisterMessage));
    }

    @Test(priority = 2)
    public void userLogin() {
        var loginPage =homePage.openLoginPage();
        loginPage.userLogin(email, jsonReader.password);
        Assert.assertTrue(homePage.getLogoutLink().contains(jsonReader.logoutLinkText));
    }

    @Test(priority = 3)
    public void SearchProductByAutoSuggest (){
        productPage = homePage.searchSuggestedProduct(jsonReader.searchText);
        Assert.assertTrue(productPage.getProductName().contains(jsonReader.searchText));
    }

    @Test(priority = 4)
    public void AddProductToCart(){

        SoftAssert softAssert = new SoftAssert();
        homePage.searchSuggestedProduct(jsonReader.searchText);
        productPage.addProductToCart();
        softAssert.assertTrue(productPage.getSuccessMessage().contains(jsonReader.cartSuccessMessage));
        cartPage = productPage.goToShoppingCart();
        softAssert.assertTrue(cartPage.getProductName().contains(jsonReader.productName));

        softAssert.assertAll();

    }

    @Test(priority = 5)
    public void confirmOrder (){

        var checkoutPage = cartPage.proceedToCheckout();
        checkoutPage.finishOrder(jsonReader.country, jsonReader.city, jsonReader.address, jsonReader.zipCode, jsonReader.phone);
        Assert.assertTrue(checkoutPage.getOrderSuccessMessage().contains(jsonReader.orderSuccessMessage));

    }




}


