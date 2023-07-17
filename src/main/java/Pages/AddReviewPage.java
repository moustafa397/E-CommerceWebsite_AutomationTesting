package Pages;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddReviewPage extends PageBase {
    public AddReviewPage(WebDriver driver) {
        super(driver);
    }

    private final By reviewTitleTxtBox = By.id("AddProductReview_Title");
    private final By reviewTextTxtBox = By.id("AddProductReview_ReviewText");
    private final By reviewRadioBtn = By.id("addproductrating_5");
    private final By submitReviewBtn = By.cssSelector("div.buttons > button");
    private final By reviewResultMessage = By.cssSelector("div.result");

    public void addReview (String title , String text){
        setTxtBoxText(reviewTitleTxtBox,title);
        setTxtBoxText(reviewTextTxtBox,text);
        clickButton(reviewRadioBtn);
        clickButton(submitReviewBtn);
    }

    public String getReviewResultMessage (){
        return getElementText(reviewResultMessage);
    }

}
