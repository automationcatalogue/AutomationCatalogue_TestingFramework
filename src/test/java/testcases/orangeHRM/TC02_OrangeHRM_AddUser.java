package testcases.orangeHRM;

import Utilities.*;
import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.orangeHRM.OrangeHRM_AddUserPage;
import pages.orangeHRM.OrangeHRM_HRAdministrationPage;
import pages.orangeHRM.OrangeHRM_HomePage;
import pages.orangeHRM.OrangeHRM_LoginPage;
import testcases.runner.Runner;

public class TC02_OrangeHRM_AddUser extends Runner {

    private static WebDriver driver;
    private static String userName, password, empName, createUserName, adminRole, newUserPassword, newUserConfirmPassword;
    private static String sheetName;
    private static int row;

    @BeforeClass
    public void preRequisites() throws Exception{
        sheetName = "HRM_AddUser";
        row = ExcelUtils.getRowNumber(Config.testID_HRMAddUser,sheetName);
        userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        empName = ExcelUtils.getCellData(sheetName, row, Config.col_EmployeeName);
        createUserName = RandomUtils.getRandomData("firstName");
        adminRole = ExcelUtils.getCellData(sheetName, row, Config.col_AdminRole);
        newUserPassword = ExcelUtils.getCellData(sheetName, row, Config.col_NewUserPassword);
        newUserConfirmPassword = ExcelUtils.getCellData(sheetName, row, Config.col_NewUserConfirmPassword);
    }

    @BeforeMethod
    public void launchURL() throws Exception{
        driver = CommonMethods.openBrowser();
        BaseClass ob = new BaseClass(driver);
        CommonMethods.launchURL(Config.orangeHRM_URL);
    }

    @Test
    public void orangeHRM_AddUser() throws Exception{
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
    }

    @AfterMethod
    public void afterMethod() throws Exception{
        CommonMethods.closeBrowser();
        ExcelUtils.setCellData(createUserName, sheetName, row, Config.col_CreateUserName);
    }
}
