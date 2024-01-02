package testcases.orangeHRM;

import Utilities.BaseClass;
import Utilities.CommonMethods;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.WebDriver;
import pages.orangeHRM.OrangeHRM_EmployeeManagement;
import pages.orangeHRM.OrangeHRM_HomePage;
import pages.orangeHRM.OrangeHRM_LoginPage;

public class TC06_OrangeHRM_Nationality {
    public static void main(String[] args) throws Exception {

        String projectPath = System.getProperty("user.dir");
        String sheetName = "HRM_Nationality";
        ExcelUtils.setExcelFilePath(projectPath + "//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_HRM_Nationality, sheetName);
        String userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        String countryName = ExcelUtils.getCellData(sheetName, row, Config.col_Nationality_CountryName);

        WebDriver driver = CommonMethods.openBrowser();
        BaseClass ob = new BaseClass(driver);

        CommonMethods.launchURL(Config.orangeHRM_URL);
        OrangeHRM_LoginPage.login(userName, password);
        OrangeHRM_HomePage.verifyTitle();
        OrangeHRM_HomePage.clickEmployeeManagement();
        OrangeHRM_EmployeeManagement.clickNationality();
        OrangeHRM_EmployeeManagement.createCountryName(countryName);
        OrangeHRM_HomePage.clickEmployeeManagement();
        OrangeHRM_EmployeeManagement.clickMyInfo();
        OrangeHRM_EmployeeManagement.clickPersonalDetails();
        OrangeHRM_EmployeeManagement.validateCountryName(countryName);
        OrangeHRM_HomePage.logout();
        CommonMethods.closeBrowser();
    }
}
