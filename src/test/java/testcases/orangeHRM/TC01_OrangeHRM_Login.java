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
        driver.get(Config.orangeHRM_URL);
        System.out.println("OrangeHRM URL is launched");

        OrangeHRM_LoginPage.orangeHRM_Login(driver, sheetName, row);

        OrangeHRM_HomePage.verifyTitle(driver);

        OrangeHRM_HomePage.logout(driver);

        driver.quit();
        System.out.println("Testcase Execution is completed and Driver instance is terminated");
    }
}
