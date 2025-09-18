package Tests;

import Pages.Purchase_page;
import Setup.BaseUrlTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Purchase_Flow {
    WebDriver driver = new ChromeDriver();
    Purchase_page Purchase = new Purchase_page(driver);

    @BeforeMethod
    public void open(){
        Purchase.Setup();
    }
//    @AfterMethod
//    public void Exit(){
//        SoftAssert Assert = new SoftAssert();
//        Assert.assertAll();
//        if (driver != null){
//            driver.quit();
//        }
//    }
    @Test
    public void Search(){
        Purchase.Search();

    }
    @Test
    public void Filter(){
        Purchase.Filter();
    }
    @Test
    public void Checkout(){
        Purchase.Checkout();
    }
    @Test
    public void Billing_form(){
        Purchase.Billing_page();
    }

    @Test
    public void Payment(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Purchase.Payment_Method();
    }







}
