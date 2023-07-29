package Tests.RegisterTests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.UserRegistrationPage;
import Tests.TestBase.TestBase;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilties.JsonDataReader;

public class ChangePasswordTest extends TestBase {
    /*
    1- User register.
    2- User log in.
    3- Navigate to my account page.
    4- Navigate to change password page.
    5- Enter old password and the new password.
    6- verify that password changed successfully.
    7- Log out.
    8- Log in using the new password.
     */

    HomePage homePage;
    UserRegistrationPage registerPage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    String email ;
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
        myAccountPage = new MyAccountPage(driver) ;
    }
    @Test(priority=1)
    public void UserRegisterSuccessfully()
    {
        homePage.openRegisterPage();
        registerPage.userRegistration(jsonReader.firstName, jsonReader.lastName, email, jsonReader.password);
        Assert.assertTrue(registerPage.getSuccessMessage().contains(jsonReader.successRegisterMessage));
    }


    @Test(priority=2)
    public void RegisteredUserLogin()
    {
        homePage.openLoginPage();
        loginPage.userLogin(email, jsonReader.password);
        Assert.assertTrue(registerPage.getLogoutLink().contains(jsonReader.logoutLinkText));
    }

    @Test(priority=3)
    public void RegisteredUserChangePassword()
    {
        registerPage.openMyAccountPage();
        myAccountPage.openChangePasswordPage();
        myAccountPage.changePassword(jsonReader.password, jsonReader.newPassword);
        Assert.assertTrue(myAccountPage.getChangePasswordResult().contains(jsonReader.passwordChangedMessage));
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
        loginPage.userLogin(email, jsonReader.newPassword);
        Assert.assertTrue(registerPage.getLogoutLink().contains(jsonReader.logoutLinkText));
    }


}
