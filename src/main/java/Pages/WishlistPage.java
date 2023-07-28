package Pages;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage extends PageBase {
    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    private final By productName = By.cssSelector(".product-name");


    public String getProductName (){
        return getElementText(productName);
    }

}
