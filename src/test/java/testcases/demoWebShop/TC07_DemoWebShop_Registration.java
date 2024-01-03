package testcases.demoWebShop;

import Utilities.*;
import org.openqa.selenium.WebDriver;
import pages.demoWebShop.DemoWebShop_HomePage;
import pages.demoWebShop.DemoWebShop_LoginPage;
import pages.demoWebShop.DemoWebShop_RegistrationPage;

public class TC07_DemoWebShop_Registration {
    public static void main(String[] args) throws Exception{
        String projectPath = System.getProperty("user.dir");
        String sheetName = "Demo_Registration";
        ExcelUtils.setExcelFilePath(projectPath+"//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_Demo_Registration,sheetName);
        String firstName = RandomUtils.getRandomData("firstName");
        String lastName = RandomUtils.getRandomData("lastName");
        String email = RandomUtils.getRandomEmail(8);
        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Registration_Password);
        String confirmPassword = ExcelUtils.getCellData(sheetName, row, Config.col_Registration_ConfirmPassword);

        WebDriver driver = CommonMethods.openBrowser();
        BaseClass ob = new BaseClass(driver);

        CommonMethods.launchURL(Config.demoWebShop_URL);
        DemoWebShop_RegistrationPage.clickRegistrationBtn();
        DemoWebShop_RegistrationPage.createNewUser(firstName, lastName, email, password, confirmPassword);
        DemoWebShop_HomePage.logout();
        DemoWebShop_RegistrationPage.clickLogin();
        DemoWebShop_LoginPage.login(email, password);
        CommonMethods.closeBrowser();

        ExcelUtils.setCellData(firstName,sheetName, row, Config.col_Registration_FirstName);
        ExcelUtils.setCellData(lastName,sheetName, row, Config.col_Registration_LastName);
        ExcelUtils.setCellData(email,sheetName, row, Config.col_Registration_Email);
    }
}
