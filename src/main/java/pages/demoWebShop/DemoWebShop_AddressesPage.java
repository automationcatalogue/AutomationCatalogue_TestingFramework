package pages.demoWebShop;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DemoWebShop_AddressesPage extends BaseClass {

    public DemoWebShop_AddressesPage(WebDriver driver){
        super(driver);
    }

    public static By link_Addresses=By.xpath("(//a[@class='inactive'])[1]");
    public static By btn_Add=By.xpath("//input[@class='button-1 add-address-button']");
    public static By txtbx_First_name=By.id("Address_FirstName");
    public static By txtbx_Last_name=By.id("Address_LastName");
    public static By txtbx_Email=By.id("Address_Email");
    public static By txtbx_Company=By.name("Address.Company");
    public static By drpdwn_Country=By.xpath("//select[@id='Address_CountryId']");
    public static By list_Countries=By.xpath("//select[@id='Address_CountryId']/option");
    public static By drpdwn_State=By.xpath("//select[@id='Address_StateProvinceId']");
    public static By list_States=By.xpath("//select[@id='Address_StateProvinceId']/option");
    public static By txtbx_City=By.xpath("//input[@id='Address_City']");
    public static By txtxbx_Address1=By.xpath("//input[@id='Address_Address1']");
    public static By txtbx_Address2=By.xpath("//input[@id='Address_Address2']");
    public static By txtbx_PostalCode=By.xpath("//input[@id='Address_ZipPostalCode']");
    public static By txtbx_PhoneNumber=By.id("Address_PhoneNumber");
    public static By txtbx_FaxNumber=By.name("Address.FaxNumber");
    public static By btn_Save=By.xpath("//input[@class='button-1 save-address-button']");
    public static By list_Addresses=By.xpath("//div[@class='address-list']/div/div[1]/strong");

    public static void clickAddresses(){
        driver.findElement(DemoWebShop_AddressesPage.link_Addresses).click();
        System.out.println("A Click on the address is done");
    }

    public static void clickAddAddress(){
        driver.findElement(DemoWebShop_AddressesPage.btn_Add).click();
        System.out.println("A click on the Add new button is been made");
    }

    public static void createAddress(String firstName, String lastName, String email, String company, String country,
                                     String province, String city, String address1, String address2, String postalCode,
                                     String phoneNumber, String faxNumber){
        driver.findElement(DemoWebShop_AddressesPage.txtbx_First_name).sendKeys(firstName);
        System.out.println("First name is been entered as "+firstName);

        driver.findElement(DemoWebShop_AddressesPage.txtbx_Last_name).sendKeys(lastName);
        System.out.println("Last name is been entered "+lastName);

        driver.findElement(DemoWebShop_AddressesPage.txtbx_Email).sendKeys(email);
        System.out.println("Email is been entered "+email);

        driver.findElement(DemoWebShop_AddressesPage.txtbx_Company).sendKeys(company);
        System.out.println("Company name is been entered "+company);

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
        driver.findElement(DemoWebShop_AddressesPage.txtbx_City).sendKeys(city);
        System.out.println("City is been entered"+city);

        driver.findElement(DemoWebShop_AddressesPage.txtxbx_Address1).sendKeys(address1);
        System.out.println("Address 1 is been entered"+address1);

        driver.findElement(DemoWebShop_AddressesPage.txtbx_Address2).sendKeys(address2);
        System.out.println("Address 2 is been entered"+address2);

        driver.findElement(DemoWebShop_AddressesPage.txtbx_PostalCode).sendKeys(postalCode);
        System.out.println("Postal code is been entered"+postalCode);

        driver.findElement(DemoWebShop_AddressesPage.txtbx_PhoneNumber).sendKeys(phoneNumber);
        System.out.println("Phone number is been entered"+phoneNumber);

        driver.findElement(DemoWebShop_AddressesPage.txtbx_FaxNumber).sendKeys(faxNumber);
        System.out.println("Fax number is been entered"+faxNumber);

        driver.findElement(DemoWebShop_AddressesPage.btn_Save).click();
        System.out.println("Save button is been clicked");
    }

    public static void validateAddress(String firstName, String lastName){
        //Validation of Address
        boolean isAddressPresent = false;
        List<WebElement> list_AddressElements = driver.findElements(DemoWebShop_AddressesPage.list_Addresses);
        for(WebElement element_address:list_AddressElements){
            String fullName = element_address.getText();
            if(fullName.equalsIgnoreCase(firstName + " "+lastName)){
                System.out.println("Create Address is successful");
                isAddressPresent = true;
                break;
            }
        }

        if(!isAddressPresent){
            System.out.println("Create Address is failed....");
        }
    }

}
