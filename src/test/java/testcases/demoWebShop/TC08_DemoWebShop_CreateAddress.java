package testcases.demoWebShop;

import Utilities.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.demoWebShop.DemoWebShop_AddressesPage;
import pages.demoWebShop.DemoWebShop_HomePage;
import pages.demoWebShop.DemoWebShop_LoginPage;

public class TC08_DemoWebShop_CreateAddress {

    @Test
    public void demoWebShop_CreateAddress() throws Exception{
        String projectPath = System.getProperty("user.dir");
        String sheetName = "Demo_CreateAddress";
        ExcelUtils.setExcelFilePath(projectPath+"//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_Demo_CreateAddress,sheetName);
        String username = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        String firstName = RandomUtils.getRandomData("firstName");
        String lastName = RandomUtils.getRandomData("lastName");
        String email = RandomUtils.getRandomEmail(8);
        String company = RandomUtils.getRandomData("company");
        String country = RandomUtils.getRandomData("country");
        String city = RandomUtils.getRandomData("city");
        String province = ExcelUtils.getCellData(sheetName, row, Config.col_CreateAddress_Province);
        String address1 = RandomUtils.getRandomData("address1");
        String address2= RandomUtils.getRandomData("address2");
        String postalCode= RandomUtils.getRandomData("zipcode");
        String phoneNumber= RandomUtils.getRandomData("phoneNumber");
        String faxNumber= ExcelUtils.getCellData(sheetName, row, Config.col_CreateAddress_FaxNumber);

        WebDriver driver = CommonMethods.openBrowser();
        BaseClass ob = new BaseClass(driver);

        CommonMethods.launchURL(Config.demoWebShopLogin_URL);
        DemoWebShop_LoginPage.login(username, password);
        DemoWebShop_HomePage.clickUserName();
        DemoWebShop_AddressesPage.clickAddresses();
        DemoWebShop_AddressesPage.clickAddAddress();
        DemoWebShop_AddressesPage.createAddress(firstName, lastName, email, company,
                country, city, province, address1, address2, postalCode, phoneNumber, faxNumber);
        DemoWebShop_AddressesPage.validateAddress(firstName, lastName);
        DemoWebShop_HomePage.logout();
        CommonMethods.closeBrowser();

        ExcelUtils.setCellData(firstName, sheetName, row, Config.col_CreateAddress_FirstName);
        ExcelUtils.setCellData(lastName, sheetName, row, Config.col_CreateAddress_LastName);
        ExcelUtils.setCellData(email, sheetName, row, Config.col_CreateAddress_EmailAddress);
        ExcelUtils.setCellData(company, sheetName, row, Config.col_CreateAddress_Company);
        ExcelUtils.setCellData(country, sheetName, row, Config.col_CreateAddress_Country);
        ExcelUtils.setCellData(city, sheetName, row, Config.col_CreateAddress_City);
        ExcelUtils.setCellData(address1, sheetName, row, Config.col_CreateAddress_Address1);
        ExcelUtils.setCellData(address2, sheetName, row, Config.col_CreateAddress_Address2);
        ExcelUtils.setCellData(postalCode, sheetName, row, Config.col_CreateAddress_PostalCode);
        ExcelUtils.setCellData(phoneNumber, sheetName, row, Config.col_CreateAddress_PhoneNumber);
    }
}
