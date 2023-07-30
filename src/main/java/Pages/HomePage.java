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
    private final By logoutLink = By.linkText("Log out");
    private final By myAccountLink = By.linkText("My account");







    public RegisterPage openRegisterPage(){

         clickButton(RegisterLink);
        return new RegisterPage(driver);
    }

    public LoginPage openLoginPage(){
        clickButton(loginLink);
        return new LoginPage(driver);
    }

    public void scrollToBottom (){

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,2500)");

    }

    public ContactUsPage openContactUsPage(){

        clickButton(contactUsLink);
        return new ContactUsPage(driver);
    }

    public ProductPage searchSuggestedProduct (String searchText){

        setTxtBoxText(searchTxtBox,searchText);

        waitTillTextAppear(searchAutoSuggestions,searchText,10);

        List<WebElement> products = driver.findElements(searchAutoSuggestions);

        products.get(0).click();

        return new ProductPage(driver);
    }

    public SearchResultsPage enterSearchText (String product){

        setTxtBoxText(searchTxtBox,product);
        clickButton(searchBtn);
        return new SearchResultsPage(driver);
    }

    public void logout()
    {
        clickButton(logoutLink);
    }

    public String getLogoutLink(){
        return  getElementText(logoutLink);
    }

    public MyAccountPage openMyAccountPage()
    {
        clickButton(myAccountLink);
        return new MyAccountPage(driver);
    }


}
