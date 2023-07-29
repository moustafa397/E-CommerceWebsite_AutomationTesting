package Pages;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By RegisterLink = By.linkText("Register");
    private final By loginLink = By.linkText("Log in");
    private final By contactUsLink = By.linkText("Contact us");
    private final By searchAutoSuggestions = By.cssSelector(".ui-menu-item > a");
    private final By searchTxtBox = By.id("small-searchterms");
    private final By searchBtn = By.cssSelector("button[type='submit']");





    public void openRegisterPage(){

         clickButton(RegisterLink);

    }

    public void openLoginPage(){
        clickButton(loginLink);
    }

    public void scrollToBottom (){

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,2500)");

    }

    public void openContactUsPage(){

        clickButton(contactUsLink);
    }

    public void searchSuggestedProduct (String searchText){

        setTxtBoxText(searchTxtBox,searchText);

        waitTillTextAppear(searchAutoSuggestions,searchText,10);

        List<WebElement> products = driver.findElements(searchAutoSuggestions);

        products.get(0).click();

    }

    public void enterSearchText (String product){

        setTxtBoxText(searchTxtBox,product);
        clickButton(searchBtn);
    }




}
