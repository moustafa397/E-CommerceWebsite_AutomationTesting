package Tests.ProductsTests;

import Pages.*;
import Tests.TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;


public class AddReviewTest extends TestBase {

     /*
    1- User register.
    2- User log in.
    3- User go to a product by auto-suggestion search.
    4- User add a review for the product.
     */

    ProductPage productPage;
    String email;


    @BeforeClass
    public void getReady (){
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


    @Test(priority=4)
    public void AddReviewToProduct(){

        var reviewPage = productPage.openAddReviewPage();
        reviewPage.addReview(jsonReader.reviewTitle, jsonReader.reviewText);
        Assert.assertTrue(reviewPage.getReviewResultMessage().contains(jsonReader.reviewSuccessMessage));

    }

}


