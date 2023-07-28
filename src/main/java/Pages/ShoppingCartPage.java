package Pages;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends PageBase {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    private final By productName = By.cssSelector(".product > a");


    public String getProductName (){
        return getElementText(productName);
    }
}
