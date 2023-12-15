package pages.orangeHRM;

import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRM_LoginPage {
    public static By txtbx_UserName = By.xpath("//input[@id='txtUsername']");
    public static By txtbx_Password = By.xpath("//input[@id='txtPassword']");
    public static By btn_Login = By.xpath("//button[@type='submit']");

    public static void orangeHRM_Login(WebDriver driver, String sheetName, int row){
        //UserName
        String userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        driver.findElement(OrangeHRM_LoginPage.txtbx_UserName).sendKeys(userName);
        System.out.println(userName + " is entered as userName");
        //Password
        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        driver.findElement(OrangeHRM_LoginPage.txtbx_Password).sendKeys(password);
        System.out.println(password + " is entered");
        //Login
        driver.findElement(OrangeHRM_LoginPage.btn_Login).click();
        System.out.println("Login button is clicked");
    }
}
