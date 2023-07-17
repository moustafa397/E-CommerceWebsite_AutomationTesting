package Pages;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends PageBase {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private final By searchTxtBox = By.id("small-searchterms");
    private final By searchBtn = By.cssSelector("button[type='submit']");

    private final By productsDisplayedTitle = By.cssSelector(".product-item > div.details > h2 > a");
    private final By searchAutoSuggestions = By.cssSelector(".ui-menu-item > a");



    public void enterSearchText (String product){

        setTxtBoxText(searchTxtBox,product);
        clickButton(searchBtn);
    }



    public List<String> getProductsDisplayedTitle() {
        List<WebElement> products = driver.findElements(productsDisplayedTitle);
        List<String> productTexts = new ArrayList<>();
        for (WebElement product : products) {
            productTexts.add(product.getText());
        }
        return productTexts;
    }

    public void searchSuggestedProduct (String searchText){

        setTxtBoxText(searchTxtBox,searchText);

        waitTillTextAppear(searchAutoSuggestions,searchText,10);

        List<WebElement> products = driver.findElements(searchAutoSuggestions);

        products.get(0).click();

    }




}
