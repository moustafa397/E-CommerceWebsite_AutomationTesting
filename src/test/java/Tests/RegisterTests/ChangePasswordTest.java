package Tests.RegisterTests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.UserRegistrationPage;
import Tests.TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends TestBase {

    HomePage homePage;
    UserRegistrationPage registerPage;
    LoginPage loginPage;
    MyAccountPage myAccountObject ;
    String oldPassword = "12345678" ;
    String newPassword = "123456" ;
    String firstName = "Mostafa" ;
    String lastName = "Ibrahem" ;
    String email = "test23s9566f59@gmail.com" ;


    @Test(priority=1)
    public void UserRegisterSuccessfully()
    {
        homePage = new HomePage(driver);
        homePage.openRegisterPage();
        registerPage = new UserRegistrationPage(driver);
        registerPage.userRegistration(firstName, lastName, email, oldPassword);
        Assert.assertTrue(registerPage.getSuccessMessage().contains("Your registration completed"));
    }


    @Test(priority=2)
    public void RegisteredUserLogin()
    {
        homePage.openLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.userLogin(email, oldPassword);
        //Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
    }

    @Test(priority=3)
    public void RegisteredUserChangePassword()
    {
        myAccountObject = new MyAccountPage(driver) ;
        registerPage.openMyAccountPage();
        myAccountObject.openChangePasswordPage();
        myAccountObject.changePassword(oldPassword, newPassword);
        Assert.assertTrue(myAccountObject.getChangePasswordResult().contains("Password was changed"));
    }

    @Test(priority=4)
    public void SignOutFromAccount()
    {
        registerPage.logout();
    }



    @Test(priority=5)
    public void loginWithNewPassword()
    {
        homePage.openLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.userLogin(email, newPassword);
        //Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
    }


    @Test(priority=6)
    public void UserLogout()
    {
        registerPage.logout();
    }

}
