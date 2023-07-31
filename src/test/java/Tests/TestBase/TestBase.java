package Tests.TestBase;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.ITestResult;
import Utilities.Helper;
import Utilities.JsonDataReader;

public class TestBase {

    public static WebDriver driver;

    protected HomePage homePage;
    protected JsonDataReader jsonReader;


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

        homePage = new HomePage(driver);
        jsonReader = new JsonDataReader();
        jsonReader.readJsonFile();
        driver.manage().window().maximize();
        goHome();

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
        driver.quit();

    }

    public void goHome(){
        driver.get("https://demo.nopcommerce.com/");
    }



}
