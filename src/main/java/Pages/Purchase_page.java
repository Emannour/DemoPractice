package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class Purchase_page {
    WebDriver driver ;
    public Purchase_page(WebDriver driver) {
        this.driver = driver;
    }

    //locators

    By Login = By.xpath("//a[text()='Log in']");

    By Email = By.xpath("//input[@id='Email']");
    By Password = By.xpath("//input[@id='Password']");
    By Login_btn = By.xpath("//div[@class='buttons']/button[@type='submit']");

    By Search = By.xpath("//input[@id='small-searchterms']");
    By Submit_btn  = By.xpath("//form/button[@type='submit']");
    By Filter = By.xpath("//select[@id='products-orderby']");
    By Product_details_btn = By.xpath("//h2[@class='product-title']/a[@href=\"/lenovo-thinkpad-carbon-laptop\"]");
    By add_to_cart = By.xpath("//button[@id=\"add-to-cart-button-9\"]");
    By Shopping_cart = By.xpath("//span[@class='cart-label']");
    By Update_qnt = By.xpath("//div[@class='quantity up']");
    By Accept_Terms = By.xpath("//input[@id='termsofservice']");
    By Checkout = By.xpath("//button[@id='checkout']");
    By Filter_choice = By.xpath("//select[@id='products-orderby']/option[4]");
    By City_field = By.id("BillingNewAddress_City");
    By Address = By.id("BillingNewAddress_Address1");
    By Zip_code = By.id("BillingNewAddress_ZipPostalCode");
    By phone = By.id("BillingNewAddress_PhoneNumber");
    By Con_btn = By.cssSelector("button.button-1.new-address-next-step-button");
    By ship_choose = By.id("shippingoption_0");
    By pay_choose = By.id("paymentmethod_0");
    By Province = By.id("BillingNewAddress_StateProvinceId");
    By Con_btn1 = By.xpath("//div[@id='shipping-method-buttons-container']/button[text()='Continue']");
    By Con_btn2 = By.xpath("//div[@id='payment-method-buttons-container']/button[text()='Continue']");
    By Con_btn3 = By.xpath("//div[@id='payment-info-buttons-container']/button[text()='Continue']");
    By Con_btn4 = By.className("button.button-1.confirm-order-next-step-button");
    By New_address = By.className("button.button-1.new-address-next-step-button");





    // Methods

    public void Setup (){
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(Login).click();
        driver.findElement(Email).sendKeys("emynour21@gmail.com");
        driver.findElement(Password).sendKeys("123456");
        driver.findElement(Login_btn).click();

        //driver.findElement(Cart).click();
    }

    public void Search (){
        driver.findElement(Search).sendKeys("laptop");
        driver.findElement(Submit_btn).click();

    }
    public void Filter (){
        driver.findElement(Search).sendKeys("laptop");
        driver.findElement(Submit_btn).click();
        driver.findElement(Filter).click();
        driver.findElement(Filter_choice).click();
    }

    public void Checkout(){
        driver.findElement(Search).sendKeys("laptop");
        driver.findElement(Submit_btn).click();
        driver.findElement(Product_details_btn).click();
        driver.findElement(add_to_cart).click();
        driver.findElement(Shopping_cart).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)) ;
        driver.findElement(Update_qnt).click();
        driver.findElement(Accept_Terms).click();
        driver.findElement(Checkout).click();

    }

   public void Billing_page(){
       driver.findElement(Shopping_cart).click();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)) ;
       driver.findElement(Update_qnt).click();
       driver.findElement(Accept_Terms).click();
       driver.findElement(Checkout).click();
       driver.findElement(City_field).sendKeys("Cairo");
       driver.findElement(Address).sendKeys("Nasrcity");
       WebElement province = driver.findElement(Province);
       Select select = new Select(province);
       select.selectByVisibleText("Alaska");

       driver.findElement(Zip_code).sendKeys("1234");
       driver.findElement(phone).sendKeys("01061833686");
       driver.findElement(Con_btn).click();
   }
    public void Payment_Method(){
        driver.findElement(Shopping_cart).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)) ;
        driver.findElement(Update_qnt).click();
        driver.findElement(Accept_Terms).click();
        driver.findElement(Checkout).click();
        driver.findElement(City_field).sendKeys("Cairo");
        driver.findElement(Address).sendKeys("Nasrcity");
        driver.findElement(Zip_code).sendKeys("1234");
        driver.findElement(phone).sendKeys("01061833686");
        WebElement province = driver.findElement(Province);
        Select select = new Select(province);
        select.selectByVisibleText("Alaska");
        driver.findElement(Con_btn).click();
        //driver.findElement(New_address).click();
        driver.findElement(Con_btn1).click();
        driver.findElement(ship_choose).click();
        driver.findElement(Con_btn1).click();
       driver.findElement(pay_choose).click();
       driver.findElement(Con_btn2).click();
      driver.findElement(Con_btn3).click();
        driver.findElement(Con_btn4).click();


    }








}
