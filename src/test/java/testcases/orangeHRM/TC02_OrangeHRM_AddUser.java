package testcases.orangeHRM;

import Utilities.CommonMethods;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.orangeHRM.OrangeHRM_AddUserPage;
import pages.orangeHRM.OrangeHRM_HRAdministrationPage;
import pages.orangeHRM.OrangeHRM_HomePage;
import pages.orangeHRM.OrangeHRM_LoginPage;

import java.time.Duration;
import java.util.List;

public class TC02_OrangeHRM_AddUser {
    public static void main(String[] args) throws Exception{
        String projectPath = System.getProperty("user.dir");
        String sheetName = "HRM_AddUser";
        ExcelUtils.setExcelFilePath(projectPath+"//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_HRMAddUser,sheetName);
        String userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        String empName = ExcelUtils.getCellData(sheetName, row, Config.col_EmployeeName);

        WebDriver driver = CommonMethods.openBrowser();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        CommonMethods.launchURL(driver, Config.orangeHRM_URL);
        OrangeHRM_LoginPage.orangeHRM_Login(driver, sheetName, row, userName, password);
        OrangeHRM_HomePage.clickHRAdministration(driver);
        OrangeHRM_HRAdministrationPage.clickAddUser(driver);
        String createUserName = ExcelUtils.getCellData(sheetName, row, Config.col_CreateUserName);
        OrangeHRM_AddUserPage.enterAddUserDetails(driver, sheetName, row, createUserName, empName);
        OrangeHRM_HomePage.logout(driver);

        //Login with New User Credentials
        OrangeHRM_LoginPage.orangeHRM_Login(driver, sheetName, row, createUserName, password);
        OrangeHRM_HomePage.verifyTitle(driver);

        //Get the Employee Name
        OrangeHRM_AddUserPage.validateUserName(driver, empName);
        OrangeHRM_HomePage.logout(driver);

        driver.quit();
        System.out.println("Testcase Execution is completed and Driver instance is terminated");
    }
}
