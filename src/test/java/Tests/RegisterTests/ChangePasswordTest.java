package Tests.RegisterTests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.UserRegistrationPage;
import Tests.TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends TestBase {

    HomePage homeObject ;
    UserRegistrationPage registerObject ;
    LoginPage loginObject ;
    MyAccountPage myAccountObject ;
    String oldPassword = "12345678" ;
    String newPassword = "123456" ;
    String firstName = "Mostafa" ;
    String lastName = "Ibrahem" ;
    String email = "test23s9566f59@gmail.com" ;


    @Test(priority=1)
    public void UserRegisterSuccessfully()
    {
        homeObject = new HomePage(driver);
        homeObject.openRegisterPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration(firstName, lastName, email, oldPassword);
        Assert.assertTrue(registerObject.getSuccessMessage().contains("Your registration completed"));
    }


    @Test(priority=2)
    public void RegisteredUserLogin()
    {
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.userLogin(email, oldPassword);
        //Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
    }

    @Test(priority=3)
    public void RegisteredUserChangePassword()
    {
        myAccountObject = new MyAccountPage(driver) ;
        registerObject.openMyAccountPage();
        myAccountObject.openChangePasswordPage();
        myAccountObject.changePassword(oldPassword, newPassword);
        Assert.assertTrue(myAccountObject.getChangePasswordResult().contains("Password was changed"));
    }

    @Test(priority=4)
    public void SignOutFromAccount()
    {
        registerObject.logout();
    }



    @Test(priority=5)
    public void loginWithNewPassword()
    {
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.userLogin(email, newPassword);
        //Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
    }


    @Test(priority=6)
    public void UserLogout()
    {
        registerObject.logout();
    }

}
