package testcases.demoWebShop;

import Utilities.BaseClass;
import Utilities.CommonMethods;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.WebDriver;
import pages.demoWebShop.DemoWebShop_LoginPage;
import pages.demoWebShop.DemoWebShop_RegistrationPage;

public class TC07_DemoWebShop_Registration {
    public static void main(String[] args) throws Exception{
        String projectPath = System.getProperty("user.dir");
        String sheetName = "Demo_Registration";
        ExcelUtils.setExcelFilePath(projectPath+"//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_Demo_Registration,sheetName);
        String firstName = ExcelUtils.getCellData(sheetName, row, Config.col_Registration_FirstName);
        String lastName = ExcelUtils.getCellData(sheetName, row, Config.col_Registration_LastName);
        String email = ExcelUtils.getCellData(sheetName, row, Config.col_Registration_Email);
        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Registration_Password);
        String confirmPassword = ExcelUtils.getCellData(sheetName, row, Config.col_Registration_ConfirmPassword);

        WebDriver driver = CommonMethods.openBrowser();
        BaseClass ob = new BaseClass(driver);

        CommonMethods.launchURL(Config.demoWebShop_URL);
        DemoWebShop_RegistrationPage.clickRegistrationBtn();
        DemoWebShop_RegistrationPage.createNewUser(firstName, lastName, email, password, confirmPassword);
        DemoWebShop_RegistrationPage.clickLogin();
        DemoWebShop_LoginPage.login(email, password);
    }
}
