package Tests.ContactUsTests;

import Pages.ContactUsPage;
import Pages.HomePage;
import Tests.TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest extends TestBase {

    ContactUsPage contactUsPage;
    HomePage home;
    @Test
    public void sendInquiryByContactUS (){
        home = new HomePage(driver);
        contactUsPage = new ContactUsPage(driver);


        home.scrollToBottom();
        home.openContactUsPage();
        contactUsPage.sendEnquiryByContactUs("Mostafa Ibrahem","mostafa@mos.com","i need help");
        Assert.assertEquals(contactUsPage.getEnquirySuccessMessage(),"Your enquiry has been successfully sent to the store owner.");


    }

}
