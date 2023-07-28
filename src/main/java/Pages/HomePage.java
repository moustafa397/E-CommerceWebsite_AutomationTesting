package Pages;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By RegisterLink = By.linkText("Register");
    private final By loginLink = By.linkText("Log in");
    private final By contactUsLink = By.linkText("Contact us");
    private final By homeProductsPrice = By.cssSelector(".price.actual-price");


    public void openRegisterPage(){

         clickButton(RegisterLink);

    }

    public void openLoginPage(){
        waitTillTextAppear(loginLink,"Log in",10);
        clickButton(loginLink);
    }

    public void scrollToBottom (){

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,2500)");

    }

    public void openContactUsPage(){

        clickButton(contactUsLink);
    }




}
