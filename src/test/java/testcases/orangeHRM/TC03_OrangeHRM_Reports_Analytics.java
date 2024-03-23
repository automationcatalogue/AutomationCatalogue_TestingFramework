package testcases.orangeHRM;

import Utilities.*;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.orangeHRM.*;

public class TC03_OrangeHRM_Reports_Analytics {

    public static WebDriver driver;
    public static String sheetName;
    public static String userName,password,reportType,folderType,reportName,displayFields;
    public static int row;
    public static String projectPath;

    @BeforeMethod
    public void preRequisites() throws Exception {
        projectPath = System.getProperty("user.dir");
        sheetName = "HRM_Reports";
        ExcelUtils.setExcelFilePath(projectPath + "//TestData//Automation_TestData.xlsx");
        row = ExcelUtils.getRowNumber(Config.testID_HRMReports, sheetName);
        String userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        String reportType = ExcelUtils.getCellData(sheetName, row, Config.col_ReportType);
        String reportName = "Automation Test Report" + RandomUtils.getRandomNumeric(5);
        String folderType = ExcelUtils.getCellData(sheetName, row, Config.col_FolderType);
        String displayFields = ExcelUtils.getCellData(sheetName, row, Config.col_DisplayFields);

        driver = CommonMethods.openBrowser();
        BaseClass ob = new BaseClass(driver);

        CommonMethods.launchURL(Config.orangeHRM_URL);
    }

    @Test
    public void orangeHRM_Reports_Analytics() throws Exception {
        OrangeHRM_LoginPage.login(userName, password);
        CommonMethods.takeScreenshot("OrangeHRMLogin");
        OrangeHRM_HomePage.clickReportsAndAnalytics();
        OrangeHRM_HomePage.verifyTitle();
        OrangeHRM_ReportAnalyticsPage.clickNewReport();
        //Report type, Folder, ReportName
        OrangeHRM_ReportsFieldsPage.selectReportType(reportType);
        OrangeHRM_ReportsFieldsPage.selectFolder(folderType);
        OrangeHRM_ReportsFieldsPage.enterReportName(reportName);
        CommonMethods.takeScreenshot("OrangeHRMReportName");
        OrangeHRM_ValidateReportsFieldsPage.enterReportDataAndValidate(reportType, reportName, displayFields);
        OrangeHRM_HomePage.logout();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        CommonMethods.closeBrowser();
        ExcelUtils.setCellData(reportName, sheetName, row, Config.col_ReportName);
    }



}

