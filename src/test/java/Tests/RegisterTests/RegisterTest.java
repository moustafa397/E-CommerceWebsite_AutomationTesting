package Tests.RegisterTests;


import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import Tests.TestBase.TestBase;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilties.JsonDataReader;


public class RegisterTest extends TestBase {

    /*
    1-open browser.
    2-navigate to home page.
    3-open register page.
    4-enter valid data and click on register.
    5-verify that the register completed successfully.
    6-login with the registered user.
    */

    HomePage homePage;
    UserRegistrationPage registerPage;
    LoginPage loginPage;
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

}
