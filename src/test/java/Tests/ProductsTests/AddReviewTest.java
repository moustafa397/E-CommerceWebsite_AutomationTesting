package Tests.ProductsTests;

import Pages.*;
import Tests.TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddReviewTest extends TestBase {

    SearchPage searchPage;
    ProductPage productPage;
    HomePage homePage;
    UserRegistrationPage registerPage;
    LoginPage loginPage;
    AddReviewPage reviewPage;

    @Test(priority=1)
    public void UserRegisterSuccessfully(){

        homePage = new HomePage(driver);
        registerPage = new UserRegistrationPage(driver);


        homePage.openRegisterPage();
        registerPage.userRegistration("Mostafa","Ibrahem","momdddxsdo@mooos.com","12345678");
        Assert.assertTrue(registerPage.getSuccessMessage().contains("Your registration completed"));

    }


    @Test(priority=2)
    public void userLogin(){

        loginPage = new LoginPage(driver);


        homePage.openLoginPage();
        loginPage.userLogin("momdddxsdo@mooos.com","12345678");
        Assert.assertTrue(registerPage.getLogoutLink().contains("Log out"));
    }

    @Test(priority=3)
    public void SearchProductByAutoSuggest (){
        searchPage = new SearchPage(driver);
        productPage = new ProductPage(driver);

        searchPage.searchSuggestedProduct("HTC");
    }


    @Test(priority=4)
    public void AddReviewToProduct(){
        reviewPage = new AddReviewPage(driver);

        productPage.openAddReviewPage();
        reviewPage.addReview("nice","very nice product");
        Assert.assertTrue(reviewPage.getReviewResultMessage().contains("Product review is successfully added."));

    }

}
