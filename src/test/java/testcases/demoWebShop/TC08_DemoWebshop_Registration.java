package testcases.demoWebShop;

import Utilities.CommonMethods;
import Utilities.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.demoWebShop.DemoWebShop_LoginPage;
import pages.demoWebShop.DemoWebShop_RegistrationPage;

public class TC08_DemoWebshop_Registration {
    public static void main(String[] args) {

        WebDriver driver = CommonMethods.openBrowser();

        driver.get(Config.demoWebShop_URL);
        System.out.println("DemoWebshop browser is loaded");

        driver.findElement(DemoWebShop_RegistrationPage.Icn_Register).click();
        System.out.println("Click on Register button");

        driver.findElement(DemoWebShop_RegistrationPage.rbtn_GenderMale).click();
        System.out.println("Click on Gender as Male");

        driver.findElement(DemoWebShop_RegistrationPage.txtbx_FirstName).sendKeys("Anupreddy");
        System.out.println("First Name is Entered");

        driver.findElement(DemoWebShop_RegistrationPage.txtbx_LastName).sendKeys("Desai");
        System.out.println("Last Name is Entered");

        driver.findElement(DemoWebShop_RegistrationPage.txtbx_Email).sendKeys("anupreddy.desai@gmail.com");
        System.out.println("Email ID is Entered");

        driver.findElement(DemoWebShop_RegistrationPage.txtbx_Password).sendKeys("Automation@123");
        System.out.println("password is entered");

        driver.findElement(DemoWebShop_RegistrationPage.txtbx_ConfirmPassword).sendKeys("Automation@123");
        System.out.println("confirm password is entered");

        driver.findElement(DemoWebShop_RegistrationPage.btn_Register).click();
        System.out.println("Register button is selected");

        driver.findElement(DemoWebShop_RegistrationPage.btn_Login).click();
        System.out.println("Login is selected");

        driver.findElement(DemoWebShop_LoginPage.txtbx_UserName).sendKeys("anupreddy.desai@gmail.com");
        System.out.println("UserName is entered for Login");

        driver.findElement(DemoWebShop_LoginPage.txtbx_Password).sendKeys("Automation@123");
        System.out.println("Password is entered for Login");

        driver.findElement(DemoWebShop_LoginPage.btn_Login).click();
        System.out.println("Login button is clicked");
    }
}
