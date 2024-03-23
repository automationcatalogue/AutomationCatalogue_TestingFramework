package testcases.orangeHRM;

import Utilities.BaseClass;
import Utilities.CommonMethods;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.orangeHRM.OrangeHRM_HomePage;
import pages.orangeHRM.OrangeHRM_LoginPage;


public class  TC01_OrangeHRM_Login {

    private static String userName, password;
    private static WebDriver driver;

    @BeforeClass
    public void preRequisites() throws Exception{
        String projectPath = System.getProperty("user.dir");
        String sheetName = "HRM_Login";
        ExcelUtils.setExcelFilePath(projectPath+"//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_HRMLogin,sheetName);
        userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
    }

    @BeforeMethod
    public void launchURL() throws Exception{
        driver = CommonMethods.openBrowser();
        BaseClass ob = new BaseClass(driver);
        CommonMethods.launchURL(Config.orangeHRM_URL);
    }

    @Test
    public void orangeRM_Login() {
        OrangeHRM_LoginPage.login(userName, password);
        OrangeHRM_HomePage.verifyTitle();
        OrangeHRM_HomePage.logout();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
        System.out.println("Testcase Execution is completed and Driver instance is terminated");
    }
}
