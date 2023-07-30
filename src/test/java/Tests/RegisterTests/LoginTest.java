package Tests.RegisterTests;


import Tests.TestBase.TestBase;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    /*
    1-open browser.
    2-navigate to home page.
    3-open register page.
    4-enter valid data and click on register.
    5-verify that the register completed successfully.
    6-login with the registered user.
    */

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
}
