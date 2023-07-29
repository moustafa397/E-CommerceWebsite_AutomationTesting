package Tests.ProductsTests;

import Pages.*;
import Tests.TestBase.TestBase;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilties.JsonDataReader;

public class RegisteredUserCheckoutTest extends TestBase {
    HomePage homePage;
    UserRegistrationPage registerPage;
    LoginPage loginPage;
    ProductPage productPage;
    ShoppingCartPage cartPage;
    CheckoutPage checkoutPage;

    String email;
    JsonDataReader jsonReader;

    @BeforeClass
    public void getReady() {
        //generate an email for register.
        Faker fakeData = new Faker();
        email = fakeData.internet().emailAddress();

        jsonReader = new JsonDataReader();
        jsonReader.readJsonFile();

        homePage = new HomePage(driver);
        registerPage = new UserRegistrationPage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new ShoppingCartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        productPage = new ProductPage(driver);


    }

    @Test(priority = 1)
    public void UserRegisterSuccessfully() {
        homePage.openRegisterPage();
        registerPage.userRegistration(jsonReader.firstName, jsonReader.lastName, email, jsonReader.password);
        Assert.assertTrue(registerPage.getSuccessMessage().contains(jsonReader.successRegisterMessage));
    }

    @Test(priority = 2)
    public void userLogin() {
        homePage.openLoginPage();
        loginPage.userLogin(email, jsonReader.password);
        Assert.assertTrue(registerPage.getLogoutLink().contains(jsonReader.logoutLinkText));
    }

    @Test(priority = 3)
    public void SearchProductByAutoSuggest (){
        homePage.searchSuggestedProduct(jsonReader.searchText);
        Assert.assertTrue(productPage.getProductName().contains(jsonReader.searchText));
    }

    @Test(priority = 4)
    public void AddProductToCart(){

        SoftAssert softAssert = new SoftAssert();

        productPage.addProductToCart();
        softAssert.assertTrue(productPage.getSuccessMessage().contains(jsonReader.cartSuccessMessage));
        productPage.goToShoppingCart();
        softAssert.assertTrue(cartPage.getProductName().contains(jsonReader.productName));

        softAssert.assertAll();

    }

    @Test(priority = 5)
    public void confirmOrder (){
        cartPage.proceedToCheckout();
        checkoutPage.finishOrder("Egypt","Cairo","33 ramses st","11672","01023231325");
        Assert.assertTrue(checkoutPage.getOrderSuccessMessage().contains(jsonReader.orderSuccessMessage));

    }




}


