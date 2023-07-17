package Tests.TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.ITestResult;
import Utilities.Helper;

public class TestBase {

    public static WebDriver driver;


    @BeforeClass
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName){

        if (browserName.equalsIgnoreCase("chrome") ) {

             driver = new ChromeDriver();


        } else if (browserName.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();

        }
        else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();

        }

        driver.manage().window().maximize();
        goHome();
    }


    public void goHome(){
        driver.get("https://demo.nopcommerce.com/");
    }


    @AfterMethod
    public void screenshotOnFailure(ITestResult result)
    {
        if (result.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("Test Failed!");
            System.out.println("Taking Screenshot..");
            Helper.takeScreenShot(driver, result.getName());
        }
    }

    @AfterClass
    public void stopDriver(){
        //driver.quit();

    }

}
