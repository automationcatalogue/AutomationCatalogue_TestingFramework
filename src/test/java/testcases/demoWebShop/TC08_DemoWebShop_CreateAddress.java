package testcases.demoWebShop;

import Utilities.BaseClass;
import Utilities.CommonMethods;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.WebDriver;
import pages.demoWebShop.DemoWebShop_AddressesPage;
import pages.demoWebShop.DemoWebShop_HomePage;
import pages.demoWebShop.DemoWebShop_LoginPage;

public class TC08_DemoWebShop_CreateAddress {
    public static void main(String[] args) throws Exception{
        String projectPath = System.getProperty("user.dir");
        String sheetName = "Demo_CreateAddress";
        ExcelUtils.setExcelFilePath(projectPath+"//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_Demo_CreateAddress,sheetName);
        String username = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        String firstName = ExcelUtils.getCellData(sheetName, row, Config.col_FirstName);
        String lastName = ExcelUtils.getCellData(sheetName, row, Config.col_LastName);
        String email = ExcelUtils.getCellData(sheetName, row, Config.col_EmailAddress);
        String company = ExcelUtils.getCellData(sheetName, row, Config.col_Company);
        String country = ExcelUtils.getCellData(sheetName, row, Config.col_Country);
        String city = ExcelUtils.getCellData(sheetName, row, Config.col_City);
        String province = ExcelUtils.getCellData(sheetName, row, Config.col_Province);
        String address1 = ExcelUtils.getCellData(sheetName, row, Config.col_Address1);
        String address2= ExcelUtils.getCellData(sheetName, row, Config.col_Address2);
        String postalCode= ExcelUtils.getCellData(sheetName, row, Config.col_PostalCode);
        String phoneNumber= ExcelUtils.getCellData(sheetName, row, Config.col_PhoneNumber);
        String faxNumber= ExcelUtils.getCellData(sheetName, row, Config.col_FaxNumber);

        WebDriver driver = CommonMethods.openBrowser();
        BaseClass ob = new BaseClass(driver);

        CommonMethods.launchURL(Config.demoWebShop_URL);
        DemoWebShop_LoginPage.login(username, password);
        DemoWebShop_HomePage.clickUserName();
        DemoWebShop_AddressesPage.clickAddresses();
        DemoWebShop_AddressesPage.clickAddAddress();
        DemoWebShop_AddressesPage.createAddress(firstName, lastName, email, company,
                country, city, province, address1, address2, postalCode, phoneNumber, faxNumber);
        DemoWebShop_AddressesPage.validateAddress(firstName, lastName);
        DemoWebShop_HomePage.logout();
        CommonMethods.closeBrowser();
    }
}
