package pages.demoWebShop;

import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoWebShop_LoginPage {
    public static By txtbx_UserName = By.xpath("//input[@id='Email']");
    public static By txtbx_Password = By.xpath("//input[@id='Password']");
    public static By btn_Login = By.xpath("//input[@class='button-1 login-button']");

    public static void login(WebDriver driver, String sheetName, int row){
        String username = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        driver.findElement(DemoWebShop_LoginPage.txtbx_UserName).sendKeys(username);
        System.out.println("User name is been entered "+username);

        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        driver.findElement(DemoWebShop_LoginPage.txtbx_Password).sendKeys(password);
        System.out.println("Password is been entered "+password);

        driver.findElement(DemoWebShop_LoginPage.btn_Login).click();
        System.out.println("Login button is been clicked");
    }
}
