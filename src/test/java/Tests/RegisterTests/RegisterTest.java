package Tests.RegisterTests;


import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import Tests.TestBase.TestBase;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class RegisterTest extends TestBase {

    HomePage homePage;
    UserRegistrationPage registerPage;
    LoginPage loginPage;
    Faker fakeData = new Faker();
    String firstName = fakeData.name().firstName();
    String lastName = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String password = fakeData.number().digits(8).toString();



    @Test
    public void UserRegisterSuccessfully(){

        homePage = new HomePage(driver);
        registerPage = new UserRegistrationPage(driver);


        homePage.openRegisterPage();
        registerPage.userRegistration(firstName,lastName,email,password);
        Assert.assertTrue(registerPage.getSuccessMessage().contains("Your registration completed"));

    }


    @AfterClass
    public void RegisteredUserLogin(){
        loginPage = new LoginPage(driver);

        homePage.openLoginPage();
        loginPage.userLogin(email,password);
        Assert.assertTrue(registerPage.getLogoutLink().contains("Log out"));
    }



}
