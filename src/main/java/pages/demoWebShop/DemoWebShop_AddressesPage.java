package pages.demoWebShop;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;

public class DemoWebShop_AddressesPage {

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

}
