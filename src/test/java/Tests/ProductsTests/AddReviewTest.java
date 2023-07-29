package Tests.ProductsTests;

import Pages.*;
import Tests.TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilties.JsonDataReader;
import com.github.javafaker.Faker;


public class AddReviewTest extends TestBase {

    SearchResultsPage searchPage;
    ProductPage productPage;
    HomePage homePage;
    UserRegistrationPage registerPage;
    LoginPage loginPage;
    AddReviewPage reviewPage;
    JsonDataReader jsonReader;
    String email;


    @BeforeClass
    public void getReady (){
        //generate an email for register.
        Faker fakeData = new Faker();
        email = fakeData.internet().emailAddress();
        jsonReader = new JsonDataReader();
        jsonReader.readJsonFile();

        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        registerPage = new UserRegistrationPage(driver);
        loginPage = new LoginPage(driver);
        searchPage = new SearchResultsPage(driver);
        reviewPage = new AddReviewPage(driver);
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


    @Test(priority=4)
    public void AddReviewToProduct(){

        productPage.openAddReviewPage();
        reviewPage.addReview(jsonReader.reviewTitle, jsonReader.reviewText);
        Assert.assertTrue(reviewPage.getReviewResultMessage().contains(jsonReader.reviewSuccessMessage));

    }

}


