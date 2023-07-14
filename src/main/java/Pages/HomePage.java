package Pages;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By RegisterLink = By.linkText("Register");
    private final By loginLink = By.linkText("Log in");


    public void openRegisterPage(){

         clickButton(RegisterLink);

    }

    public void openLoginPage(){

        clickButton(loginLink);
    }

}
