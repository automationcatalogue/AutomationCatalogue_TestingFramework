package testcases.demoWebShop;

import Utilities.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.demoWebShop.DemoWebShop_AddressesPage;
import pages.demoWebShop.DemoWebShop_HomePage;
import pages.demoWebShop.DemoWebShop_LoginPage;

public class TC08_DemoWebShop_CreateAddress {

    private static String username,password,firstName,lastName,email,company,country,city,province;
    private static String address1,address2,postalCode,phoneNumber,faxNumber;
    private static int row;
    private static String sheetName;
    private static WebDriver driver;

    @BeforeClass
    public void preRequisites() throws Exception{
        String projectPath = System.getProperty("user.dir");
        sheetName = "Demo_CreateAddress";
        ExcelUtils.setExcelFilePath(projectPath + "//TestData//Automation_TestData.xlsx");
        row = ExcelUtils.getRowNumber(Config.testID_Demo_CreateAddress, sheetName);
        username = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        firstName = RandomUtils.getRandomData("firstName");
        lastName = RandomUtils.getRandomData("lastName");
        email = RandomUtils.getRandomEmail(8);
        company = RandomUtils.getRandomData("company");
        country = RandomUtils.getRandomData("country");
        city = RandomUtils.getRandomData("city");
        province = ExcelUtils.getCellData(sheetName, row, Config.col_CreateAddress_Province);
        address1 = RandomUtils.getRandomData("address1");
        address2 = RandomUtils.getRandomData("address2");
        postalCode = RandomUtils.getRandomData("zipcode");
        phoneNumber = RandomUtils.getRandomData("phoneNumber");
        faxNumber = ExcelUtils.getCellData(sheetName, row, Config.col_CreateAddress_FaxNumber);

    }

    @BeforeMethod
    public void launchURL() throws Exception {
        driver = CommonMethods.openBrowser();
        BaseClass ob = new BaseClass(driver);
        CommonMethods.launchURL(Config.demoWebShopLogin_URL);
    }

    @Test
    public void demoWebShop_CreateAddress(){
        DemoWebShop_LoginPage.login(username, password);
        DemoWebShop_HomePage.clickUserName();
        DemoWebShop_AddressesPage.clickAddresses();
        DemoWebShop_AddressesPage.clickAddAddress();
        DemoWebShop_AddressesPage.createAddress(firstName, lastName, email, company,
                country, city, province, address1, address2, postalCode, phoneNumber, faxNumber);
        DemoWebShop_AddressesPage.validateAddress(firstName, lastName);
        DemoWebShop_HomePage.logout();

    }

    @AfterMethod
    public void tearDown() throws Exception{
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
