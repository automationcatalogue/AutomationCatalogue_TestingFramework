package testcases.orangeHRM;

import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.orangeHRM.OrangeHRM_HomePage;
import pages.orangeHRM.OrangeHRM_LoginPage;

import java.time.Duration;

public class   TC01_OrangeHRM_Login {
    public static void main(String[] args) throws Exception{
        String projectPath = System.getProperty("user.dir");
        String sheetName = "HRM_Login";
        ExcelUtils.setExcelFilePath(projectPath+"//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_HRMLogin,sheetName);

        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome Browser is launched");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Opening OrangeHRM Application
        driver.get("https://testcatalogu-trials711.orangehrmlive.com/");
        System.out.println("OrangeHRM URL is launched");
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

        //Title Verification
        String title = driver.getTitle();
        if(title.equalsIgnoreCase("Employee Management")){
            System.out.println("Login is successful");
        }else{
            System.out.println("Login is not successful");
        }

        //Logout
        driver.findElement(OrangeHRM_HomePage.link_Logout).click();
        System.out.println("Logout button is clicked");

        driver.quit();
        System.out.println("Testcase Execution is completed and Driver instance is terminated");
    }
}
