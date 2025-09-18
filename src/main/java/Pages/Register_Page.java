package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register_Page  {

    static WebDriver driver;

    public static void setDriver( WebDriver driver) {
        Register_Page.driver = driver;
    }

    //Locators

    By Male_locator = By.xpath("//input[@id ='gender-male']");
    By Female_locator = By.xpath("//input[@id ='gender-female']");
    By F_N_Mandatory_locator =  By.xpath("//input[@id='FirstName']/following-sibling::span[text()='*']");
    By Register_btn = By.xpath("//button[text()='Register']");
    By F_N_Msg_Error = By.xpath("//span[@id='FirstName-error']");
    By First_Name = By.xpath("//input[@id='FirstName']");
    By Last_Name = By.xpath("//input[@id='LastName']") ;
    By Email = By.xpath("//input[@id='Email']");
    By company = By.xpath("//input[@id='Company']");
    By Password = By.xpath("//input[@id='Password']");
    By Confirm_Pass = By.xpath("//input[@id='ConfirmPassword']");
    By Reg_confirmation = By.xpath("//div[text()='Your registration completed']");
    By Reg_error = By.xpath("//span[@id='ConfirmPassword-error']");


    //Methods


    public void Select_Male(){
        driver.findElement(Male_locator).click();
    }

    public boolean Is_Male_Selected(){

        return      driver.findElement(Male_locator).isSelected();
    }
    public void Select_Female(){

        driver.findElement(Female_locator).click();
    }

    public boolean Is_Female_Selected(){

        return driver.findElement(Female_locator).isSelected();
    }

    public String F_N_Mandatory1(){
       return driver.findElement(F_N_Mandatory_locator).getText();

    }
    public String F_N_msg_error(){
        return driver.findElement(F_N_Msg_Error).getText();
    }

    public void Add_F_N(String Name){
        driver.findElement(First_Name).sendKeys(Name);
    }

    public void Register_Btn(){
        driver.findElement(Register_btn).click();
    }

    public void Add_L_N(String Name){
        driver.findElement(Last_Name).sendKeys(Name);
    }
    public void Add_Email(String E_mail){
        driver.findElement(Email).sendKeys(E_mail);
    }
    public void Add_company(String Company){
        driver.findElement(company).sendKeys(Company);

    }
    public void Add_Password(String password){
        driver.findElement(Password).sendKeys(password);

    }
    public void Add_Confirm_pass(String confirm_Pass){
        driver.findElement(Confirm_Pass).sendKeys(confirm_Pass);
    }

    public String Pass_Text(){
       return driver.findElement(Password).getAttribute("value");
    }
    public String con_pass_text(){
       return driver.findElement(Confirm_Pass).getAttribute("value");
    }
    public String Text_register(){
       return driver.findElement(Reg_confirmation).getText();
    }
    public String Text_error(){
        return driver.findElement(Reg_error).getText();
    }

    public void Exit(){
        driver.quit();
    }




}
