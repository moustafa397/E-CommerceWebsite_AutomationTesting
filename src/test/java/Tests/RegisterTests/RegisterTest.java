package Tests.RegisterTests;


import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import Tests.TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class RegisterTest extends TestBase {

    HomePage homePage;
    UserRegistrationPage registerPage;
    LoginPage loginPage;


    @Test
    public void UserRegisterSuccessfully(){

        homePage = new HomePage(driver);
        registerPage = new UserRegistrationPage(driver);


        homePage.openRegisterPage();
        registerPage.userRegistration("Mostafa","Ibrahem","sasas12lfl34556@sas.com","12345678");
        Assert.assertTrue(registerPage.getSuccessMessage().contains("Your registration completed"));

    }


    @AfterClass
    public void RegisteredUserLogin(){

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new UserRegistrationPage(driver);


        homePage.openLoginPage();
        loginPage.userLogin("sasa12lfl34556@sas.com","12345678");
        Assert.assertTrue(registerPage.getLogoutLink().contains("Log out"));
    }



}
