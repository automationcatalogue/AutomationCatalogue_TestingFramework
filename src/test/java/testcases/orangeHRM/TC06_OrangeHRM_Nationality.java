package testcases.orangeHRM;

import Utilities.BaseClass;
import Utilities.CommonMethods;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.orangeHRM.OrangeHRM_EmployeeManagement;
import pages.orangeHRM.OrangeHRM_HomePage;
import pages.orangeHRM.OrangeHRM_LoginPage;

public class TC06_OrangeHRM_Nationality {

    private static WebDriver driver;
    private static String userName, password, countryName;
    private static String sheetName;
    private static int row;

    @BeforeClass
    public void preRequisite() throws Exception {
        String projectPath = System.getProperty("user.dir");
        sheetName = "HRM_Nationality";
        ExcelUtils.setExcelFilePath(projectPath + "//TestData//Automation_TestData.xlsx");
        row = ExcelUtils.getRowNumber(Config.testID_HRM_Nationality, sheetName);
        userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        countryName = ExcelUtils.getCellData(sheetName, row, Config.col_Nationality_CountryName);

    }

    @BeforeMethod
    public void launchURL() throws Exception {
        driver = CommonMethods.openBrowser();
        BaseClass ob = new BaseClass(driver);
        CommonMethods.launchURL(Config.orangeHRM_URL);
    }

    @Test
    public void OrangeHRM_Nationality() {
        OrangeHRM_LoginPage.login(userName, password);
        OrangeHRM_HomePage.verifyTitle();
        OrangeHRM_HomePage.clickEmployeeManagement();
        OrangeHRM_EmployeeManagement.clickNationality();
        OrangeHRM_EmployeeManagement.createCountryName(countryName);
        OrangeHRM_HomePage.clickEmployeeManagement();
        OrangeHRM_EmployeeManagement.clickMyInfo();
        OrangeHRM_EmployeeManagement.clickPersonalDetails();
        OrangeHRM_EmployeeManagement.validateCountryName(countryName);
    }

    @AfterMethod
    public void tearDown(){
        OrangeHRM_HomePage.logout();
        CommonMethods.closeBrowser();
    }
}
