package Pages;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver){

        super(driver);

    }


    private final By emailTxtBox = By.id("Email");
    private final By passwordTxtBox = By.id("Password");
    private final By loginBtn = By.cssSelector("button.button-1.login-button") ;


    public void userLogin(String email, String password){

        setTxtBoxText(emailTxtBox,email);
        setTxtBoxText(passwordTxtBox,password);
        clickButton(loginBtn);
    }



}
