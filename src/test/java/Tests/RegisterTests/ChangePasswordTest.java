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
    MyAccountPage myAccountPage;
    String oldPassword = "12345678" ;
    String newPassword = "123456" ;
    String firstName = "Mostafa" ;
    String lastName = "Ibrahem" ;
    String email = "sososossg6f6fdd7956@gmail.com" ;


    @Test(priority=1)
    public void UserRegisterSuccessfully()
    {
        homePage = new HomePage(driver);
        registerPage = new UserRegistrationPage(driver);

        homePage.openRegisterPage();
        registerPage.userRegistration(firstName, lastName, email, oldPassword);
        Assert.assertTrue(registerPage.getSuccessMessage().contains("Your registration completed"));
    }


    @Test(priority=2)
    public void RegisteredUserLogin()
    {
        loginPage = new LoginPage(driver);

        homePage.openLoginPage();
        loginPage.userLogin(email, oldPassword);
        Assert.assertTrue(registerPage.getLogoutLink().contains("Log out"));
    }

    @Test(priority=3)
    public void RegisteredUserChangePassword()
    {
        myAccountPage = new MyAccountPage(driver) ;

        registerPage.openMyAccountPage();
        myAccountPage.openChangePasswordPage();
        myAccountPage.changePassword(oldPassword, newPassword);
        Assert.assertTrue(myAccountPage.getChangePasswordResult().contains("Password was changed"));
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
        loginPage.userLogin(email, newPassword);
        Assert.assertTrue(registerPage.getLogoutLink().contains("Log out"));
    }


    @Test(priority=6)
    public void UserLogout()
    {
        registerPage.logout();
    }

}
