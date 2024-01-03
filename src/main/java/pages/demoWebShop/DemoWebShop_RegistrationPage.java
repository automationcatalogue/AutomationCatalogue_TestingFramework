package pages.demoWebShop;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoWebShop_RegistrationPage extends BaseClass {

    public DemoWebShop_RegistrationPage(WebDriver driver){
        super(driver);
    }

    public static By Icn_Register = By.xpath("//a[@class='ico-register']");
    public static By rbtn_GenderMale = By.xpath("//input[@id='gender-male']");
    public static By txtbx_FirstName = By.xpath("//input[@id='FirstName']");
    public static By txtbx_LastName = By.xpath("//input[@id='LastName']");
    public static By txtbx_Email = By.xpath("//input[@id='Email']");
    public static By txtbx_Password = By.xpath("//input[@id='Password']");
    public static By txtbx_ConfirmPassword = By.xpath("//input[@id='ConfirmPassword']");
    public static By btn_Register = By.xpath("//input[@id='register-button']");
    public static By btn_Login = By.xpath("//a[@class='ico-login']");

    public static void clickRegistrationBtn(){
        driver.findElement(DemoWebShop_RegistrationPage.Icn_Register).click();
        System.out.println("Click on Register button");
    }

    public static void createNewUser(String firstName, String lastName, String email, String password, String confirmPassword){
        driver.findElement(DemoWebShop_RegistrationPage.rbtn_GenderMale).click();
        System.out.println("Click on Gender as Male");

        driver.findElement(DemoWebShop_RegistrationPage.txtbx_FirstName).sendKeys(firstName);
        System.out.println("First Name is Entered as "+firstName);

        driver.findElement(DemoWebShop_RegistrationPage.txtbx_LastName).sendKeys(lastName);
        System.out.println("Last Name is Entered as "+lastName);

        driver.findElement(DemoWebShop_RegistrationPage.txtbx_Email).sendKeys(email);
        System.out.println("Email ID is Entered as "+email);

        driver.findElement(DemoWebShop_RegistrationPage.txtbx_Password).sendKeys(password);
        System.out.println("password is entered");

        driver.findElement(DemoWebShop_RegistrationPage.txtbx_ConfirmPassword).sendKeys(confirmPassword);
        System.out.println("confirm password is entered");

        driver.findElement(DemoWebShop_RegistrationPage.btn_Register).click();
        System.out.println("Register button is selected");
    }

    public static void clickLogin(){
        driver.findElement(DemoWebShop_RegistrationPage.btn_Login).click();
        System.out.println("Login is selected");
    }

}
