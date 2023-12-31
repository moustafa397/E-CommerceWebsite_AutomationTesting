package Tests.ContactUsTests;


import Tests.TestBase.TestBase;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContactUsTest extends TestBase {
    /*
    1- Navigate to home page.
    2- Scroll down.
    1- click on contact us .
    2- Send an enquiry.
    3- Verify that your enquiry has been sent successfully.
     */

    String email;

    @BeforeClass
    public void getReady (){
        //generate an email.
        Faker fakeData = new Faker();
        email = fakeData.internet().emailAddress();
    }
    @Test
    public void sendInquiryByContactUS (){
        homePage.scrollToBottom();
        var contactUsPage = homePage.openContactUsPage();
        contactUsPage.sendEnquiryByContactUs(jsonReader.firstName, email, jsonReader.enquiryText);
        Assert.assertEquals(contactUsPage.getEnquirySuccessMessage(),jsonReader.enquirySuccessMessage);
    }

}
