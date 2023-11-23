package testcases.demoWebShop;

import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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

        driver.get("http://demowebshop.tricentis.com/login");
        System.out.println("Demo workshop website will be open");

        String username = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        driver.findElement(By.xpath("//div[@class='inputs']/input")).sendKeys(username);
        System.out.println("User name is been entered "+username);

        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        driver.findElement(By.xpath("(//div[@class='inputs']/input)[2]")).sendKeys(password);
        System.out.println("Password is been entered "+password);

        driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
        System.out.println("Login button is been clicked");

        driver.findElement(By.xpath("(//a[@class='account'])[1]")).click();
        System.out.println("User name is been clicked");

        driver.findElement(By.xpath("(//a[@class='inactive'])[1]")).click();
        System.out.println("A Click on the address is done");

        driver.findElement(By.xpath("//input[@class='button-1 add-address-button']")).click();
        System.out.println("A click on the Add new button is been made");

        String FirstName = ExcelUtils.getCellData(sheetName, row, Config.col_FirstName);
        driver.findElement(By.id("Address_FirstName")).sendKeys(FirstName);
        System.out.println("First name is been entered as "+FirstName);

        String LastName = ExcelUtils.getCellData(sheetName, row, Config.col_LastName);
        driver.findElement(By.id("Address_LastName")).sendKeys(LastName);
        System.out.println("Last name is been entered "+LastName);

        String emailAddress = ExcelUtils.getCellData(sheetName, row, Config.col_EmailAddress);
        driver.findElement(By.id("Address_Email")).sendKeys(emailAddress);
        System.out.println("Email is been entered "+emailAddress);

        String company = ExcelUtils.getCellData(sheetName, row, Config.col_Company);
        driver.findElement(By.name("Address.Company")).sendKeys(company);
        System.out.println("Company name is been entered "+company);

        String country = ExcelUtils.getCellData(sheetName, row, Config.col_Country);
        driver.findElement(By.xpath("//select[@id='Address_CountryId']")).click();
        System.out.println("Country dropdown is been clicked");
        List<WebElement> Country = driver.findElements(By.xpath("//select[@id='Address_CountryId']/option"));
        for (WebElement element: Country){
            String actualValue = element.getText();
            if (actualValue.equalsIgnoreCase("Canada")){
                element.click();
                break;
            }
        }
        System.out.println("Canada is been selected from the drop down"+country);

        String province = ExcelUtils.getCellData(sheetName, row, Config.col_Province);
        driver.findElement(By.xpath("//select[@id='Address_StateProvinceId']")).click();
        System.out.println("State/Province dropdown is been selected");
        List<WebElement> Province = driver.findElements(By.xpath("//select[@id='Address_StateProvinceId']/option"));
        for (WebElement element: Province){
            String actualValue =element.getText();
            if (actualValue.equalsIgnoreCase("Ontario")){
                element.click();
                break;
            }
        }
        System.out.println("Ontario is been selected"+province);

        String cityName = ExcelUtils.getCellData(sheetName, row, Config.col_City);
        driver.findElement(By.xpath("//input[@id='Address_City']")).sendKeys(cityName);
        System.out.println("City is been entered"+cityName);

        String address1 = ExcelUtils.getCellData(sheetName, row, Config.col_Address1);
        driver.findElement(By.xpath("//input[@id='Address_Address1']")).sendKeys(address1);
        System.out.println("Address 1 is been entered"+address1);

        String address2= ExcelUtils.getCellData(sheetName, row, Config.col_Address2);
        driver.findElement(By.xpath("//input[@id='Address_Address2']")).sendKeys(address2);
        System.out.println("Address 2 is been entered"+address2);

        String postalcode= ExcelUtils.getCellData(sheetName, row, Config.col_PostalCode);
        driver.findElement(By.xpath("//input[@id='Address_ZipPostalCode']")).sendKeys(postalcode);
        System.out.println("Postal code is been entered"+postalcode);

        String phonenumber= ExcelUtils.getCellData(sheetName, row, Config.col_PhoneNumber);
        driver.findElement(By.id("Address_PhoneNumber")).sendKeys(phonenumber);
        System.out.println("Phone number is been entered"+phonenumber);

        String Faxnumber= ExcelUtils.getCellData(sheetName, row, Config.col_FaxNumber);
        driver.findElement(By.name("Address.FaxNumber")).sendKeys(Faxnumber);
        System.out.println("Fax number is been entered"+Faxnumber);

        driver.findElement(By.xpath("//input[@class='button-1 save-address-button']")).click();
        System.out.println("Save button is been clicked");

        //Validation of Address
        boolean isAddressPresent = false;
        List<WebElement> list_AddressElements = driver.findElements(By.xpath("//div[@class='address-list']/div/div[1]/strong"));
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

        //Logout from DemoWebshop testcase
        driver.findElement(By.linkText("Log out")).click();
        System.out.println("Successfully logout");
        //driver.quit();
    }
}
