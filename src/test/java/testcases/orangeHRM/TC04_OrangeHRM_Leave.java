package testcases.orangeHRM;

import Utilities.BaseClass;
import Utilities.CommonMethods;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.orangeHRM.OrangeHRM_HomePage;
import pages.orangeHRM.OrangeHRM_LeavePage;
import pages.orangeHRM.OrangeHRM_LoginPage;
import pages.orangeHRM.OrangeHRM_WorkingWeekendPage;

public class TC04_OrangeHRM_Leave {

    private static String userName, password, name, date, hours,country;
    private static WebDriver driver;

    @BeforeClass
    public void preRequisites() throws Exception{
        String projectPath = System.getProperty("user.dir");
        String sheetName = "HRM_Leave";
        ExcelUtils.setExcelFilePath(projectPath + "//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_HRMLeave, sheetName);
        userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        name = ExcelUtils.getCellData(sheetName, row, Config.col_Name);
        date = ExcelUtils.getCellData(sheetName, row, Config.col_Date);
        hours = ExcelUtils.getCellData(sheetName, row, Config.col_Workinghours);
        country = ExcelUtils.getCellData(sheetName, row, Config.col_country);
    }
    @BeforeMethod
    public void launchURL() throws Exception {
        driver = CommonMethods.openBrowser();
        BaseClass ob = new BaseClass(driver);
        CommonMethods.launchURL(Config.orangeHRM_URL);
    }

    @Test
    public void OrangeHRM_Leave() throws Exception {
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
    }

    @AfterMethod
    public void afterMethod() throws Exception{
        CommonMethods.closeBrowser();
    }

}

