package Tests.RegisterTests;


import Tests.TestBase.TestBase;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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



    String email ;


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

    @Test(priority=3)
    public void RegisteredUserChangePassword()
    {
        var myAccountPage = homePage.openMyAccountPage();
        myAccountPage.openChangePasswordPage();
        myAccountPage.changePassword(jsonReader.password, jsonReader.newPassword);
        Assert.assertTrue(myAccountPage.getChangePasswordResult().contains(jsonReader.passwordChangedMessage));
    }

    @Test(priority=4)
    public void SignOutFromAccount()
    {
        homePage.logout();
    }



    @Test(priority=5)
    public void loginWithNewPassword()
    {
        var loginPage =homePage.openLoginPage();
        loginPage.userLogin(email, jsonReader.newPassword);
        Assert.assertTrue(homePage.getLogoutLink().contains(jsonReader.logoutLinkText));
    }


}
