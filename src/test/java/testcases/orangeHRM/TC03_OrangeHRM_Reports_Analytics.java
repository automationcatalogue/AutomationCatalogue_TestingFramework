package testcases.orangeHRM;

import Utilities.CommonMethods;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.orangeHRM.*;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class TC03_OrangeHRM_Reports_Analytics {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static String sheetName;
    public static int row;
    public static JavascriptExecutor js;
    public static TakesScreenshot ts;
    public static File src, dest;
    public static String projectPath;

    public static void main(String[] args) throws Exception {
        projectPath = System.getProperty("user.dir");
        sheetName = "HRM_Reports";
        ExcelUtils.setExcelFilePath(projectPath + "//TestData//Automation_TestData.xlsx");
        row = ExcelUtils.getRowNumber(Config.testID_HRMReports, sheetName);
        String userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        String reportType = ExcelUtils.getCellData(sheetName, row, Config.col_ReportType);
        String reportName = ExcelUtils.getCellData(sheetName, row, Config.col_ReportName);

        driver = CommonMethods.openBrowser();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        js =(JavascriptExecutor)driver;
        ts = (TakesScreenshot) driver;

        driver.get(Config.orangeHRM_URL);
        System.out.println("OrangeHRM Application is loaded");

        OrangeHRM_LoginPage.orangeHRM_Login(driver, sheetName, row, userName, password);
        CommonMethods.takeScreenshot(driver,"OrangeHRMLogin");
        OrangeHRM_HomePage.clickReportsAndAnalytics(driver);
        OrangeHRM_HomePage.verifyTitle(driver);
        OrangeHRM_ReportAnalyticsPage.clickNewReport(driver);


        //Report type
        OrangeHRM_ReportsFieldsPage.selectReportType(driver, sheetName, row, reportType);

        //Folder
        OrangeHRM_ReportsFieldsPage.selectFolder(driver, sheetName, row);

        //Report Name
        OrangeHRM_ReportsFieldsPage.enterReportName(driver, sheetName, row, reportName);
        CommonMethods.takeScreenshot(driver, "OrangeHRMReportName");

        OrangeHRM_ValidateReportsFieldsPage.enterReportDataAndValidate(driver, sheetName, row, reportType, reportName);

        OrangeHRM_HomePage.logout(driver);

        driver.quit();
        System.out.println("Testcase Execution is completed and Driver instance is terminated");
    }


}

