package Pages;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends PageBase {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }


    private final By productsDisplayedTitle = By.cssSelector(".product-item > div.details > h2 > a");



    public List<String> getProductsDisplayedTitle() {
        List<WebElement> products = driver.findElements(productsDisplayedTitle);
        List<String> productTexts = new ArrayList<>();
        for (WebElement product : products) {
            productTexts.add(product.getText());
        }
        return productTexts;
    }





}
