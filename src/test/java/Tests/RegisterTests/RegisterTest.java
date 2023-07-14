package Tests.RegisterTests;


import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import Tests.TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RegisterTest extends TestBase {

    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;


    @Test(priority = 1,alwaysRun = true)
    public void UserRegisterSuccessfully(){

        homeObject = new HomePage(driver);
        registerObject = new UserRegistrationPage(driver);

        homeObject.openRegisterPage();
        registerObject.userRegistration("Mostafa","Ibrahem","sasa1234556@sas.com","12345678");
        Assert.assertTrue(registerObject.getSuccessMessage().contains("Your registration completed"));

    }


    @Test (priority = 2)
    public void UserLoginSuccessfully(){


        loginObject = new LoginPage(driver);

        homeObject.openLoginPage();
        loginObject.userLogin("sasa123456@sas.com","12345678");
       // Assert.assertTrue(registerObject.getLogoutLink().contains("Log out"));
    }



}
