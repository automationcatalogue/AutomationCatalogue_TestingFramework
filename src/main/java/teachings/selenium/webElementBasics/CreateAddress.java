package teachings.selenium.webElementBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class CreateAddress {
   /* public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome browser is launched");

        driver.manage().window().maximize();
        System.out.println("Browser window is maximized");

        driver.get("http://demowebshop.tricentis.com/login");
        System.out.println("Demo Webshop website is loaded");

        driver.findElement(By.id("Email")).sendKeys(CreateAddressData.userName);
        System.out.println("UserName is entered");

        driver.findElement(By.name("Password")).sendKeys(CreateAddressData.password);
        System.out.println("Password is entered");

        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click();
        System.out.println("Login button is clicked");

        driver.findElement(By.linkText("aarosagarch@gmail.com")).click();
        System.out.println("Email link is clicked");

        driver.findElement(By.linkText("Addresses")).click();
        System.out.println("Address Link is clicked");

        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[2]/input")).click();
        System.out.println("Add New button is clicked");

        driver.findElement(By.id("Address_FirstName")).sendKeys(CreateAddressData.firstName);
        System.out.println("FirstName is entered");

        driver.findElement(By.name("Address.LastName")).sendKeys(CreateAddressData.lastName);
        System.out.println("LastName is entered");

        driver.findElement(By.xpath("//*[@id='Address_Email']")).sendKeys(CreateAddressData.email);
        System.out.println("Email is entered");

        driver.findElement(By.cssSelector("#Address_Company")).sendKeys(CreateAddressData.company);
        System.out.println("Company name is entered");

        WebElement element_country = driver.findElement(By.id("Address_CountryId"));
        Select ob_country = new Select(element_country);
        ob_country.selectByVisibleText(CreateAddressData.country);
        System.out.println("Country drop-down is selected");

        WebElement element_state =  driver.findElement(By.name("Address.StateProvinceId"));
        Select ob_state = new Select(element_state);
        ob_state.selectByVisibleText(CreateAddressData.state);
        System.out.println("State drop-down is selected");

        driver.findElement(By.id("Address_City")).sendKeys(CreateAddressData.city);
        System.out.println("City name is entered");

        driver.findElement(By.id("Address_Address1")).sendKeys(CreateAddressData.address1);
        System.out.println("Address1 is entered");

        driver.findElement(By.name("Address.Address2")).sendKeys(CreateAddressData.address2);
        System.out.println("Address2 is entered");

        driver.findElement(By.name("Address.ZipPostalCode")).sendKeys(CreateAddressData.postalCode);
        System.out.println("Postal Code is entered");

        driver.findElement(By.id("Address_PhoneNumber")).sendKeys(CreateAddressData.phoneNumber);
        System.out.println("Phone Number is entered");

        driver.findElement(By.name("Address.FaxNumber")).sendKeys(CreateAddressData.faxNumber);
        System.out.println("Fax Number is entered");

        driver.findElement(By.className("button-1 save-address-button")).click();
        System.out.println("Save button is clicked");

    }*/
}
