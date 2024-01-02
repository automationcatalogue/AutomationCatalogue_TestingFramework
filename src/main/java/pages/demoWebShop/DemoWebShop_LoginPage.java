package pages.demoWebShop;

import Utilities.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoWebShop_LoginPage extends BaseClass {

    public DemoWebShop_LoginPage(WebDriver driver){
        super(driver);
    }

    public static By txtbx_UserName = By.xpath("//input[@id='Email']");
    public static By txtbx_Password = By.xpath("//input[@id='Password']");
    public static By btn_Login = By.xpath("//input[@class='button-1 login-button']");

    public static void login(String username, String password){
        driver.findElement(DemoWebShop_LoginPage.txtbx_UserName).sendKeys(username);
        System.out.println("User name is been entered "+username);

        driver.findElement(DemoWebShop_LoginPage.txtbx_Password).sendKeys(password);
        System.out.println("Password is been entered "+password);

        driver.findElement(DemoWebShop_LoginPage.btn_Login).click();
        System.out.println("Login button is been clicked");
    }
}
