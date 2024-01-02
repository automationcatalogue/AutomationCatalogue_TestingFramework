package testcases.orangeHRM;

import Utilities.BaseClass;
import Utilities.CommonMethods;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.WebDriver;
import pages.orangeHRM.OrangeHRM_HomePage;
import pages.orangeHRM.OrangeHRM_LeavePage;
import pages.orangeHRM.OrangeHRM_LoginPage;
import pages.orangeHRM.OrangeHRM_WorkingWeekendPage;

public class TC04_OrangeHRM_Leave {
    public static void main(String[] args) throws Exception {
        String projectPath = System.getProperty("user.dir");
        String sheetName = "HRM_Leave";
        ExcelUtils.setExcelFilePath(projectPath + "//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_HRMLeave, sheetName);
        String userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        String name = ExcelUtils.getCellData(sheetName, row, Config.col_Name);
        String date = ExcelUtils.getCellData(sheetName, row, Config.col_Date);
        String hours = ExcelUtils.getCellData(sheetName, row, Config.col_Workinghours);
        String country = ExcelUtils.getCellData(sheetName, row, Config.col_country);

        WebDriver driver = CommonMethods.openBrowser();
        BaseClass ob = new BaseClass(driver);

        CommonMethods.launchURL(Config.orangeHRM_URL);
        OrangeHRM_LoginPage.login(userName, password);
        OrangeHRM_HomePage.verifyTitle();
        OrangeHRM_HomePage.clickLeaveLink();
        OrangeHRM_LeavePage.clickConfigureLink();
        OrangeHRM_LeavePage.clickWorkingWeekends();
        OrangeHRM_WorkingWeekendPage.enterName(name);
        OrangeHRM_WorkingWeekendPage.selectDate(date);
        OrangeHRM_WorkingWeekendPage.enterWorkingHours(hours);
        OrangeHRM_WorkingWeekendPage.selectCountry(country);
        OrangeHRM_WorkingWeekendPage.validateName(name);
        Thread.sleep(2000);
        OrangeHRM_HomePage.logout();
        CommonMethods.closeBrowser();
    }
}

