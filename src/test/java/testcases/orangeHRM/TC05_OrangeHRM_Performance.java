package testcases.orangeHRM;

import Utilities.BaseClass;
import Utilities.CommonMethods;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.orangeHRM.*;
import pages.orangeHRM.OrangeHRM_HomePage;
import pages.orangeHRM.OrangeHRM_LoginPage;

public class TC05_OrangeHRM_Performance {

    @Test
    public void orangeHRM_Performance() throws Exception {
        String projectPath = System.getProperty("user.dir");
        String sheetName = "HRM_Performance";
        ExcelUtils.setExcelFilePath(projectPath + "//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_HRM_Performance, sheetName);
        String userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        String empName = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_EmployeeName);
        String description = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_Description);
        String appraisalCycle = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_AppraisalCycle);
        String newUserPassword = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_UserName_Password);
        String userPassword = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_UserName_Password);
        String newUserConfirmPassword = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_UserName_ConfirmPassword);
        String fromDate = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_FromDate);
        String toDate = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_ToDate);
        String dueDate = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_DueDate);

        WebDriver driver = CommonMethods.openBrowser();
        BaseClass ob = new BaseClass(driver);

        CommonMethods.launchURL(Config.orangeHRM_URL);
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
        OrangeHRM_HomePage.logout();
        CommonMethods.closeBrowser();

    }
}
