package testcases.orangeHRM;

import Utilities.*;
import org.openqa.selenium.*;
import pages.orangeHRM.OrangeHRM_AddUserPage;
import pages.orangeHRM.OrangeHRM_HRAdministrationPage;
import pages.orangeHRM.OrangeHRM_HomePage;
import pages.orangeHRM.OrangeHRM_LoginPage;

public class TC02_OrangeHRM_AddUser {
    public static void main(String[] args) throws Exception{
        String projectPath = System.getProperty("user.dir");
        String sheetName = "HRM_AddUser";
        ExcelUtils.setExcelFilePath(projectPath+"//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_HRMAddUser,sheetName);
        String userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        String empName = ExcelUtils.getCellData(sheetName, row, Config.col_EmployeeName);
        String createUserName = RandomUtils.getRandomData("firstName");
        String adminRole = ExcelUtils.getCellData(sheetName, row, Config.col_AdminRole);
        String newUserPassword = ExcelUtils.getCellData(sheetName, row, Config.col_NewUserPassword);
        String newUserConfirmPassword = ExcelUtils.getCellData(sheetName, row, Config.col_NewUserConfirmPassword);

        WebDriver driver = CommonMethods.openBrowser();
        BaseClass ob = new BaseClass(driver);

        CommonMethods.launchURL(Config.orangeHRM_URL);
        OrangeHRM_LoginPage.login(userName, password);
        OrangeHRM_HomePage.clickHRAdministration();
        OrangeHRM_HRAdministrationPage.clickAddUser();
        OrangeHRM_AddUserPage.enterAddUserDetails(createUserName, empName, adminRole, newUserPassword, newUserConfirmPassword);
        OrangeHRM_HomePage.logout();
        //Login with New User Credentials
        OrangeHRM_LoginPage.login(createUserName, newUserPassword);
        OrangeHRM_HomePage.verifyTitle();
        //Get the Employee Name
        OrangeHRM_AddUserPage.validateUserName(empName);
        OrangeHRM_HomePage.logout();
        CommonMethods.closeBrowser();

        ExcelUtils.setCellData(createUserName, sheetName, row, Config.col_CreateUserName);
    }
}
