package testcases.orangeHRM;

import Utilities.BaseClass;
import Utilities.CommonMethods;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.orangeHRM.*;
import pages.orangeHRM.OrangeHRM_HomePage;
import pages.orangeHRM.OrangeHRM_LoginPage;

public class TC05_OrangeHRM_Performance {

    private static WebDriver driver;
    private static String userName, password, empName, description, appraisalCycle, newUserPassword, userPassword;
    private static String newUserConfirmPassword, fromDate, toDate, dueDate;
    private static String sheetName;
    private static int row;



    @BeforeMethod
    public void preRequisites() throws Exception {
        String projectPath = System.getProperty("user.dir");
        sheetName = "HRM_Performance";
        ExcelUtils.setExcelFilePath(projectPath + "//TestData//Automation_TestData.xlsx");
        row = ExcelUtils.getRowNumber(Config.testID_HRM_Performance, sheetName);
        userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        empName = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_EmployeeName);
        description = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_Description);
        appraisalCycle = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_AppraisalCycle);
        newUserPassword = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_UserName_Password);
        userPassword = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_UserName_Password);
        newUserConfirmPassword = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_UserName_ConfirmPassword);
        fromDate = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_FromDate);
        toDate = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_ToDate);
        dueDate = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_DueDate);

        driver = CommonMethods.openBrowser();
        BaseClass ob = new BaseClass(driver);

        CommonMethods.launchURL(Config.orangeHRM_URL);

    }

    @Test
    public void OrangeHRM_Performance() throws Exception {
        OrangeHRM_LoginPage.login(userName, password);
        OrangeHRM_HomePage.verifyTitle();
        OrangeHRM_HomePage.clickPerformanceLink();
        OrangeHRM_PerformancePage.clickAddAppraisalBtn();
        OrangeHRM_AddEmployeeAppraisalPage.enterAddAppraisalEmployeeDetails(empName, description, appraisalCycle);
        OrangeHRM_AddEmployeeAppraisalPage.selectFromDate(fromDate);
        OrangeHRM_AddEmployeeAppraisalPage.selectToDate(toDate);
        OrangeHRM_AddEmployeeAppraisalPage.selectDueDate(dueDate);
        OrangeHRM_Evaluator.clickSelfAppraisal();
        OrangeHRM_AppraisalMultipleView.submitAppraisal();
        OrangeHRM_HomePage.clickHRAdministration();
        String userName_Employee = OrangeHRM_HRAdministrationPage.clickEditEmployee(empName, sheetName, row);
        OrangeHRM_HRAdministrationPage.changePassword(newUserPassword, newUserConfirmPassword);
        OrangeHRM_HomePage.logout();
        OrangeHRM_LoginPage.login(userName_Employee, userPassword);
        OrangeHRM_HomePage.verifyTitle();
        OrangeHRM_HomePage.clickPerformanceLink();
        OrangeHRM_PerformancePage.clickMyAppraisalBtn();
        OrangeHRM_MyAppraisalPage.validateAppraisalData(description);

    }

    @AfterMethod
    public void tearDown(){
        OrangeHRM_HomePage.logout();
        CommonMethods.closeBrowser();

    }
}
