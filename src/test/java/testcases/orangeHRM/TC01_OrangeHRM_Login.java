package testcases.orangeHRM;

import Utilities.BaseClass;
import Utilities.CommonMethods;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.WebDriver;
import pages.orangeHRM.OrangeHRM_HomePage;
import pages.orangeHRM.OrangeHRM_LoginPage;


public class   TC01_OrangeHRM_Login {
    public static void main(String[] args) throws Exception{
        String projectPath = System.getProperty("user.dir");
        String sheetName = "HRM_Login";
        ExcelUtils.setExcelFilePath(projectPath+"//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_HRMLogin,sheetName);
        String userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);

        WebDriver driver = CommonMethods.openBrowser();
        BaseClass ob = new BaseClass(driver);

        CommonMethods.launchURL(Config.orangeHRM_URL);
        OrangeHRM_LoginPage.login(userName, password);
        OrangeHRM_HomePage.verifyTitle();
        OrangeHRM_HomePage.logout();

        driver.quit();
        System.out.println("Testcase Execution is completed and Driver instance is terminated");
    }
}
