package Pages;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends PageBase {

    public RegisterPage(WebDriver driver){
        super(driver);
    }



    private final By genderRadioButton = By.id("gender-male");
    private final By fnTxtBox = By.id("FirstName");
    private final By lnTxtBox = By.id("LastName");
    private final By emailTxtBox = By.id("Email");
    private final By passwordTxtBox = By.id("Password");
    private final By confirmPasswordTxtBox = By.id("ConfirmPassword");
    private final By registerBtn = By.id("register-button");
    private final By  successMessage = By.cssSelector("div.result");


    public void userRegistration(String firstName, String lastName ,String email, String password){

        clickButton(genderRadioButton);
        setTxtBoxText(fnTxtBox,firstName);
        setTxtBoxText(lnTxtBox,lastName);
        setTxtBoxText(emailTxtBox,email);
        setTxtBoxText(passwordTxtBox,password);
        setTxtBoxText(confirmPasswordTxtBox,password);
        clickButton(registerBtn);


    }

    public String getSuccessMessage(){
       return getElementText(successMessage);
    }


}
