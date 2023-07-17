package Tests.RegisterTests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import Tests.TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    HomePage homePage;
    UserRegistrationPage registerPage;
    LoginPage loginPage;


    @BeforeClass
    public void UserRegisterSuccessfully(){

        homePage = new HomePage(driver);
        registerPage = new UserRegistrationPage(driver);


        homePage.openRegisterPage();
        registerPage.userRegistration("Mostafa","Ibrahem","sasass12lfl34556@sas.com","12345678");
        Assert.assertTrue(registerPage.getSuccessMessage().contains("Your registration completed"));

    }


    @Test
    public void userLogin(){

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new UserRegistrationPage(driver);


        homePage.openLoginPage();
        loginPage.userLogin("sasa12lfl34556@sas.com","12345678");
        Assert.assertTrue(registerPage.getLogoutLink().contains("Log out"));
    }
}
