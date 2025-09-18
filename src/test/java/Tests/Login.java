package Tests;

import Pages.Login_page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Login {
    WebDriver driver = new ChromeDriver();
    Login_page loginPage = new Login_page(driver);

    @BeforeMethod
    public void Setup(){
        loginPage.Open();
    }
    @AfterMethod
    public void Exit(){

        SoftAssert Assert = new SoftAssert();
        Assert.assertAll();
    }

    @Test
    public void Pass_login(){
        loginPage.Email("emynour123@gmail.com");
        loginPage.Password("123456");
        loginPage.Login_btn();
        Assert.assertEquals(loginPage.Acc_details(),"My account");
    }

}
