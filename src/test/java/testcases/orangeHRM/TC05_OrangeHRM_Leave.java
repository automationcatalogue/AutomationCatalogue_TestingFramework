package testcases.orangeHRM;

import Utilities.CommonMethods;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.orangeHRM.OrangeHRM_HomePage;
import pages.orangeHRM.OrangeHRM_LeavePage;
import pages.orangeHRM.OrangeHRM_LoginPage;
import pages.orangeHRM.OrangeHRM_WorkingWeekendPage;

import java.time.Duration;
import java.util.List;

public class TC05_OrangeHRM_Leave {
    public static void main(String[] args) throws Exception {
        String projectPath = System.getProperty("user.dir");
        String sheetName = "HRM_Leave";
        ExcelUtils.setExcelFilePath(projectPath + "//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_HRMLeave, sheetName);
        String userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        String name = ExcelUtils.getCellData(sheetName, row, Config.col_Name);

        WebDriver driver = CommonMethods.openBrowser();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get(Config.orangeHRM_URL);
        System.out.println("Orange HRM Application is loaded");

        OrangeHRM_LoginPage.orangeHRM_Login(driver, sheetName, row, userName, password);

        OrangeHRM_HomePage.verifyTitle(driver);
        OrangeHRM_HomePage.clickLeaveLink(driver);
        OrangeHRM_LeavePage.clickConfigureLink(driver);
        OrangeHRM_LeavePage.clickWorkingWeekends(driver);
        OrangeHRM_WorkingWeekendPage.enterName(driver, sheetName, row, name);
        OrangeHRM_WorkingWeekendPage.selectDate(driver, sheetName, row);
        OrangeHRM_WorkingWeekendPage.enterWorkingHours(driver, sheetName,row);
        OrangeHRM_WorkingWeekendPage.selectCountry(driver,sheetName, row);
        OrangeHRM_WorkingWeekendPage.validateName(driver, name);

        Thread.sleep(2000);
        OrangeHRM_HomePage.logout(driver);

        driver.quit();
        System.out.println("Testcase Execution is completed and Driver instance is terminated");
    }
}

