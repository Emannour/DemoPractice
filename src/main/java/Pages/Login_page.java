package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_page {
    WebDriver driver ;
    public Login_page(WebDriver driver) {
        this.driver = driver;
    }

    //locators

    By Email = By.xpath("//input[@id='Email']");
    By Password = By.xpath("//input[@id='Password']");
    By Login_btn = By.xpath("//div[@class='buttons']/button[@type='submit']");
    By Acc_page = By.xpath("//a[@class='ico-account']");

    //Methods

    public void Open(){
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
    }
    public void Email(String email){
        driver.findElement(Email).sendKeys(email);
    }
    public void Password(String password){
        driver.findElement(Password).sendKeys(password);
    }
    public void Login_btn(){
        driver.findElement(Login_btn).click();
    }
    public String Acc_details(){
       return driver.findElement(Acc_page).getText();
    }

}
