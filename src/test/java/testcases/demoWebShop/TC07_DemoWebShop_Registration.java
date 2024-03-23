package testcases.demoWebShop;

import Utilities.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.demoWebShop.DemoWebShop_HomePage;
import pages.demoWebShop.DemoWebShop_LoginPage;
import pages.demoWebShop.DemoWebShop_RegistrationPage;

public class TC07_DemoWebShop_Registration {

    private static String firstName,lastName,email,password,confirmPassword;
    private static int row;
    private static String sheetName;

    @BeforeMethod

    public void preRequisites() throws Exception {
        String projectPath = System.getProperty("user.dir");
        sheetName = "Demo_Registration";
        ExcelUtils.setExcelFilePath(projectPath + "//TestData//Automation_TestData.xlsx");
        row = ExcelUtils.getRowNumber(Config.testID_Demo_Registration, sheetName);
        firstName = RandomUtils.getRandomData("firstName");
        lastName = RandomUtils.getRandomData("lastName");
        email = RandomUtils.getRandomEmail(8);
        password = ExcelUtils.getCellData(sheetName, row, Config.col_Registration_Password);
        confirmPassword = ExcelUtils.getCellData(sheetName, row, Config.col_Registration_ConfirmPassword);

        WebDriver driver = CommonMethods.openBrowser();
        BaseClass ob = new BaseClass(driver);

        CommonMethods.launchURL(Config.demoWebShop_URL);
    }

    @Test
    public void demoWebShop_Registration() {
        DemoWebShop_RegistrationPage.clickRegistrationBtn();
        DemoWebShop_RegistrationPage.createNewUser(firstName, lastName, email, password, confirmPassword);
        DemoWebShop_HomePage.logout();
        DemoWebShop_RegistrationPage.clickLogin();
        DemoWebShop_LoginPage.login(email, password);
    }

    @AfterMethod
    public void tearDown() throws Exception{
        CommonMethods.closeBrowser();
        ExcelUtils.setCellData(firstName,sheetName, row, Config.col_Registration_FirstName);
        ExcelUtils.setCellData(lastName,sheetName, row, Config.col_Registration_LastName);
        ExcelUtils.setCellData(email,sheetName, row, Config.col_Registration_Email);
    }

}
