package Pages;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends PageBase {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    private final By productName = By.cssSelector(".product > a");
    private final By termsCheckBox = By.id("termsofservice");
    private final By checkoutBtn = By.id("checkout");



    public String getProductName (){
        return getElementText(productName);
    }
    public CheckoutPage proceedToCheckout () {
        clickButton(termsCheckBox);
        clickButton(checkoutBtn);
        return new CheckoutPage(driver);
    }

}
