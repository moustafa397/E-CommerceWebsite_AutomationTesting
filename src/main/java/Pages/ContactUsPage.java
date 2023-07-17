package Pages;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage extends PageBase {
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    private final By nameTxtBox = By.id("FullName");
    private final By emailTxtBox = By.id("Email");
    private final By enquiryTxtBox = By.id("Enquiry");
    private final By submitBtn = By.cssSelector(".buttons > button ");
    private final By successMessage = By.cssSelector("div.result");


    public void sendEnquiryByContactUs (String name, String email , String enquiry){

        setTxtBoxText(nameTxtBox,name);
        setTxtBoxText(emailTxtBox,email);
        setTxtBoxText(enquiryTxtBox,enquiry);
        clickButton(submitBtn);

    }

    public String getEnquirySuccessMessage() {
        return getElementText(successMessage);
    }




}
