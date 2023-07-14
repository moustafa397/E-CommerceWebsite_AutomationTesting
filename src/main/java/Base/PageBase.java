package Base;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {

    protected WebDriver driver;


    public PageBase(WebDriver driver){

        this.driver = driver;
    }
    protected void clickButton (By button){

        driver.findElement(button).click();

    }

    protected void setTxtBoxText(By textElement,String value){

        driver.findElement(textElement).sendKeys(value);
    }

    protected String getElementText(By textElement){

        return driver.findElement(textElement).getText();
    }

    protected void waitTillTextAppear (By element, String text , int waitTime){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(element,text));

    }

}
