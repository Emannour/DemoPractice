package Setup;

import Pages.Register_Page;
import Tests.Register;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import util.ConfigReader;
import util.ExtentManager;

import java.awt.image.PixelGrabber;
import java.io.IOException;
import java.lang.reflect.Method;

import static util.ExtentManager.extent;

public class BaseUrlTest {


//    protected static ExtentReports extent;
//    protected ExtentTest test;


//    @BeforeSuite
//    public void setupReport() {
//        extent = ExtentManager.getInstance();
//    }

//    @BeforeMethod
//    public void setUp(Method method) {
//        test = extent.createTest(method.getName());
//    }


    static protected WebDriver driver;
    By Register_icon = By.xpath("//a[text()='Register']");
    @BeforeMethod
    public void Setup () throws IOException {

//        ConfigReader.loadConfig();
//        String env = ConfigReader.get("env");
//        String url = ConfigReader.get("url_" + env);
        driver = new ChromeDriver();
        Register_Page.setDriver(driver);
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(Register_icon).click();
//        driver.get(url);

    }

    @AfterMethod
    public void Exit(){
//        if (result.getStatus() == ITestResult.FAILURE) {
//            test.fail("Test Failed: " + result.getThrowable());
//        } else if (result.getStatus() == ITestResult.SUCCESS) {
//            test.pass("Test Passed");
//        } else {
//            test.skip("Test Skipped");
//        }

        SoftAssert Assert = new SoftAssert();
        Assert.assertAll();
        if (driver != null){
            driver.quit();
        }
    }

//        @AfterSuite
//        public void flushReport() {
//            extent.flush();
//        }


}
