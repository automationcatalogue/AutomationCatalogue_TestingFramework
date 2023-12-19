package testcases.demoWebShop;

import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.demoWebShop.DemoWebShop_AddressesPage;
import pages.demoWebShop.DemoWebShop_HomePage;
import pages.demoWebShop.DemoWebShop_LoginPage;

import java.time.Duration;
import java.util.List;

public class TC09_DemoWebshop_CreateAddress {
    public static void main(String[] args) throws Exception{
        String projectPath = System.getProperty("user.dir");
        String sheetName = "Demo_CreateAddress";
        ExcelUtils.setExcelFilePath(projectPath+"//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_Demo_CreateAddress,sheetName);

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("Chrome browser will be launched");

        driver.manage().window().maximize();
        System.out.println("Chrome window will be maximized");

        driver.get(Config.demoWebShopLogin_URL);
        System.out.println("Demo workshop website will be open");

        DemoWebShop_LoginPage.login(driver, sheetName, row);

        driver.findElement(DemoWebShop_HomePage.link_UserName).click();
        System.out.println("User name is been clicked");

        driver.findElement(DemoWebShop_AddressesPage.link_Addresses).click();
        System.out.println("A Click on the address is done");

        driver.findElement(DemoWebShop_AddressesPage.btn_Add).click();
        System.out.println("A click on the Add new button is been made");

        String FirstName = ExcelUtils.getCellData(sheetName, row, Config.col_FirstName);
        driver.findElement(DemoWebShop_AddressesPage.txtbx_First_name).sendKeys(FirstName);
        System.out.println("First name is been entered as "+FirstName);

        String LastName = ExcelUtils.getCellData(sheetName, row, Config.col_LastName);
        driver.findElement(DemoWebShop_AddressesPage.txtbx_Last_name).sendKeys(LastName);
        System.out.println("Last name is been entered "+LastName);

        String emailAddress = ExcelUtils.getCellData(sheetName, row, Config.col_EmailAddress);
        driver.findElement(DemoWebShop_AddressesPage.txtbx_Email).sendKeys(emailAddress);
        System.out.println("Email is been entered "+emailAddress);

        String company = ExcelUtils.getCellData(sheetName, row, Config.col_Company);
        driver.findElement(DemoWebShop_AddressesPage.txtbx_Company).sendKeys(company);
        System.out.println("Company name is been entered "+company);

        String country = ExcelUtils.getCellData(sheetName, row, Config.col_Country);
        driver.findElement(DemoWebShop_AddressesPage.drpdwn_Country).click();
        System.out.println("Country dropdown is been clicked");
        List<WebElement> Country = driver.findElements(DemoWebShop_AddressesPage.list_Countries);
        for (WebElement element: Country){
            String actualValue = element.getText();
            if (actualValue.equalsIgnoreCase("Canada")){
                System.out.println("Canada is been selected from the drop down"+country);
                element.click();
                break;
            }
        }


        String province = ExcelUtils.getCellData(sheetName, row, Config.col_Province);
        driver.findElement(DemoWebShop_AddressesPage.drpdwn_State).click();
        System.out.println("State/Province dropdown is been selected");
        List<WebElement> Province = driver.findElements(DemoWebShop_AddressesPage.list_States);
        for (WebElement element: Province){
            String actualValue =element.getText();
            if (actualValue.equalsIgnoreCase("Ontario")){
                element.click();
                System.out.println("Ontario is been selected"+province);
                break;
            }
        }

        String cityName = ExcelUtils.getCellData(sheetName, row, Config.col_City);
        driver.findElement(DemoWebShop_AddressesPage.txtbx_City).sendKeys(cityName);
        System.out.println("City is been entered"+cityName);

        String address1 = ExcelUtils.getCellData(sheetName, row, Config.col_Address1);
        driver.findElement(DemoWebShop_AddressesPage.txtxbx_Address1).sendKeys(address1);
        System.out.println("Address 1 is been entered"+address1);

        String address2= ExcelUtils.getCellData(sheetName, row, Config.col_Address2);
        driver.findElement(DemoWebShop_AddressesPage.txtbx_Address2).sendKeys(address2);
        System.out.println("Address 2 is been entered"+address2);

        String postalCode= ExcelUtils.getCellData(sheetName, row, Config.col_PostalCode);
        driver.findElement(DemoWebShop_AddressesPage.txtbx_PostalCode).sendKeys(postalCode);
        System.out.println("Postal code is been entered"+postalCode);

        String phoneNumber= ExcelUtils.getCellData(sheetName, row, Config.col_PhoneNumber);
        driver.findElement(DemoWebShop_AddressesPage.txtbx_PhoneNumber).sendKeys(phoneNumber);
        System.out.println("Phone number is been entered"+phoneNumber);

        String FaxNumber= ExcelUtils.getCellData(sheetName, row, Config.col_FaxNumber);
        driver.findElement(DemoWebShop_AddressesPage.txtbx_FaxNumber).sendKeys(FaxNumber);
        System.out.println("Fax number is been entered"+FaxNumber);

        driver.findElement(DemoWebShop_AddressesPage.btn_Save).click();
        System.out.println("Save button is been clicked");

        //Validation of Address
        boolean isAddressPresent = false;
        List<WebElement> list_AddressElements = driver.findElements(DemoWebShop_AddressesPage.list_Addresses);
        for(WebElement element_address:list_AddressElements){
            String fullName = element_address.getText();
            if(fullName.equalsIgnoreCase(FirstName + " "+LastName)){
                System.out.println("Create Address is successful");
                isAddressPresent = true;
                break;
            }
        }

        if(!isAddressPresent){
            System.out.println("Create Address is failed....");
        }

        DemoWebShop_HomePage.logout(driver);

        driver.quit();
    }
}
