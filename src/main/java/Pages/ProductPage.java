package Pages;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends PageBase {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private final By productName = By.cssSelector(".product-name > h1");
    private final By productPrice = By.cssSelector(".product-price > span");
    private final By currencyDropdown = By.id("customerCurrency");
    private final By addReviewBtn = By.linkText("Add your review");



    public String getProductName (){
       return getElementText(productName);
    }

    public String getProductPrice (){
        return  getElementText(productPrice);
    }

    public void changeCurrency (String option){
        selectFromDropDown(currencyDropdown,option);
    }

    public void openAddReviewPage () {
        clickButton(addReviewBtn);
    }


}
