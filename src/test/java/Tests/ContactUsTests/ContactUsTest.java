package Tests.ContactUsTests;

import Pages.ContactUsPage;
import Pages.HomePage;
import Tests.TestBase.TestBase;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilties.JsonDataReader;

public class ContactUsTest extends TestBase {

    ContactUsPage contactUsPage;
    HomePage homePage;
    JsonDataReader jsonReader;
    String email;



    @BeforeClass
    public void getReady (){
        //generate an email for register.
        Faker fakeData = new Faker();
        email = fakeData.internet().emailAddress();
        jsonReader = new JsonDataReader();
        jsonReader.readJsonFile();

        homePage = new HomePage(driver);
        contactUsPage = new ContactUsPage(driver);
    }
    @Test
    public void sendInquiryByContactUS (){
        homePage.scrollToBottom();
        homePage.openContactUsPage();
        contactUsPage.sendEnquiryByContactUs(jsonReader.firstName, email, jsonReader.enquiryText);
        Assert.assertEquals(contactUsPage.getEnquirySuccessMessage(),jsonReader.enquirySuccessMessage);
    }

}
