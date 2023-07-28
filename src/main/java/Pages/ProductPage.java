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
    private final By addToWishlistBtn = By.id("add-to-wishlist-button-18");
    private final By successMessage =  By.cssSelector(".content");
    private final By wishlistBtn = By.linkText("Wishlist");
    private final By shoppingCartBtn = By.linkText("Shopping cart");
    private final By addToCartBtn = By.id("add-to-cart-button-18");
    private final By successMessageCloseBtn = By.cssSelector("span.close");








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

    public void addToWishlist (){
        clickButton(addToWishlistBtn);
    }

    public String getSuccessMessage() {
        waitTillElementAppear(successMessage,10);
        clickButton(successMessageCloseBtn);
        return getElementText(successMessage);
    }

    public void goToWishlist (){
        clickButton(wishlistBtn);
    }

    public void addProductToCart (){
        clickButton(addToCartBtn);
    }

    public void goToShoppingCart (){
        clickButton(shoppingCartBtn);
    }


}
