package Tests;

import Pages.Register_Page;
import Setup.BaseUrlTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.sound.sampled.Port;
import java.time.Duration;

public class Register  extends BaseUrlTest {

    Register_Page register_page = new Register_Page();

    @Test
    public void Male_Selected(){
        register_page.Select_Male();
        Assert.assertTrue(register_page.Is_Male_Selected());
    }

    @Test
    public void Female_Selected(){

        register_page.Select_Female();
        Assert.assertTrue(register_page.Is_Female_Selected());

    }

    @Test
    public void unselected_more_value(){

        register_page.Select_Male();
        Assert.assertTrue(register_page.Is_Male_Selected());
        Assert.assertFalse(register_page.Is_Female_Selected());
        register_page.Select_Female();
        Assert.assertTrue(register_page.Is_Female_Selected());
        Assert.assertFalse(register_page.Is_Male_Selected());

    }

    @Test
    public void F_N_mandatory(){

      Assert.assertEquals(register_page.F_N_Mandatory1(),"*");
      register_page.Add_F_N("");
      register_page.Register_Btn();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
      Assert.assertEquals(register_page.F_N_msg_error(),"First name is required.");
    }

    @Test
    public void Email_Founded(){

        register_page.Add_F_N("Eman");
        register_page.Add_L_N("Nour");
        register_page.Add_Email("emynour@gmail.com");
        register_page.Add_company("exab");
        register_page.Add_Password("123456");
        register_page.Add_Confirm_pass("123456");
        register_page.Register_Btn();
        WebElement Email_Found = driver.findElement(By.xpath("//li[text()='The specified email already exists']"));
        Assert.assertEquals(Email_Found.getText(),"The specified email already exists" );

    }

    @Test
    public void Reg_Confirm(){

        register_page.Add_F_N("Eman");
        register_page.Add_L_N("Nour");
        register_page.Add_Email("emynour21@gmail.com");
        register_page.Add_company("exab");
        register_page.Add_Password("123456");
        register_page.Add_Confirm_pass("123456");
        register_page.Register_Btn();
        // String Element2 =driver.findElement(By.xpath("//input[@id='Password']")).getText();
        // String Element3 =  driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).getText();

        Assert.assertEquals(register_page.Text_register(),"Your registration completed");
        //Assert.ass ertEquals(Element2,Element3);

     }

     @Test
    public void Pass_Match(){
         register_page.Add_F_N("Eman");
         register_page.Add_L_N("Nour");
         register_page.Add_Email("emynour8@gmail.com");
         register_page.Add_company("exab");
         register_page.Add_Password("123456");
         register_page.Add_Confirm_pass("123456");
         register_page.Register_Btn();
         //String Element2 =driver.findElement(By.xpath("//input[@id='Password']")).getText();
         // String Element3 =  driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).getText();

         Assert.assertEquals(register_page.Pass_Text(),register_page.con_pass_text());

     }

     @Test
    public void Pass_error_exeption(){
         register_page.Add_F_N("Eman");
         register_page.Add_L_N("Nour");
         register_page.Add_Email("emynour68@gmail.com");
         register_page.Add_company("Exab");
         register_page.Add_Password("123456");
         register_page.Add_Confirm_pass("12345");
         register_page.Register_Btn();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
         Assert.assertEquals(register_page.Text_error(),"The password and confirmation password do not match.");

     }
}
