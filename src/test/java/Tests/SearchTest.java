package Tests;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.security.PublicKey;
import java.sql.Driver;

public class SearchTest {
    WebDriver Driver = new ChromeDriver();
    @BeforeSuite
    @BeforeTest

    @BeforeClass
    @BeforeMethod
    public void Setup(){
        Driver.get("https://demo.nopcommerce.com/");
        //  Driver.manage().window().maximize();
    }

    @Test
    public void Search_bar1(){

        Driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("1");
        Driver.findElement(By.xpath("//button[@type='submit']")).click();
        String Error_msg = Driver.findElement(By.xpath("//input[@id='small-searchterms']")).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Search term minimum length is 3 characters",Error_msg);
    }
    @Test
    public void Search_bar2(){

        Driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("1234");
        Driver.findElement(By.xpath("//button[@type='submit']")).click();
        String Error_msg = Driver.findElement(By.xpath("//div[@class='no-result']")).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("No products were found that matched your criteria.",Error_msg);
    }
    @Test
    public void Search_Button(){
        Driver.findElement(By.xpath("//button[@type='submit']")).click();
        Alert alert = Driver.switchTo().alert();
        String Alert_msg = alert.getText();
        Assert.assertEquals("Please enter some search keyword" ,Alert_msg);
        alert.accept();
    }
    @Test
    public void Action(){
        Actions Action = new Actions(Driver);
        WebElement Element = Driver.findElement(By.xpath("//div/ul/li/a[text()='Computers ']"));
        Action.moveToElement(Element).perform();
        WebElement Element1 = Driver.findElement(By.xpath("//a[text()='Desktops ']"));
        WebElement Element2 = Driver.findElement(By.xpath("//a[text()='Notebooks ']"));
        WebElement Element3 = Driver.findElement(By.xpath("//a[text()='Software ']"));
//        Assert.assertEquals(Element1.getText(),"Desktops");
//        Assert.assertEquals(Element2.getText(),"Notebooks");
//        Assert.assertEquals(Element3.getText(),"Software");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(Element1.getText(),"Desktops");
        softAssert.assertEquals(Element2.getText(),"Notebooks");
        softAssert.assertEquals(Element3.getText(),"Software");
        softAssert.assertAll();
    }


}
