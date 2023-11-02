package testcases.demoWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class TC09_DemoWebshop_CreateAddress {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("Chrome browser will be launched");

        driver.manage().window().maximize();
        System.out.println("Chrome window will be maximized");

        driver.get("http://demowebshop.tricentis.com/login");
        System.out.println("Demo workshop website will be open");

        driver.findElement(By.xpath("//div[@class='inputs']/input")).sendKeys("aarosagarch@gmail.com");
        System.out.println("User name is been entered");

        driver.findElement(By.xpath("(//div[@class='inputs']/input)[2]")).sendKeys("Admin@123");
        System.out.println("Password is been entered");

        driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
        System.out.println("Login button is been clicked");

        driver.findElement(By.xpath("(//a[@class='account'])[1]")).click();
        System.out.println("User name is been clicked");

        driver.findElement(By.xpath("(//a[@class='inactive'])[1]")).click();
        System.out.println("A Click on the address is done");

        driver.findElement(By.xpath("//input[@class='button-1 add-address-button']")).click();
        System.out.println("A click on the Add new button is been made");

        driver.findElement(By.id("Address_FirstName")).sendKeys("Asma");
        System.out.println("First name is been entered");

        driver.findElement(By.id("Address_LastName")).sendKeys("Test");
        System.out.println("Last name is been entered");

        driver.findElement(By.id("Address_Email")).sendKeys("asma.test@gmail.com");
        System.out.println("Email is been entered");

        driver.findElement(By.name("Address.Company")).sendKeys("Automation Catalogue");
        System.out.println("Company name is been entered");

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
        System.out.println("Canada is been selected from the drop down");

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
        System.out.println("Ontario is been selected");

        driver.findElement(By.xpath("//input[@id='Address_City']")).sendKeys("Toronto");
        System.out.println("City is been entered");

        driver.findElement(By.xpath("//input[@id='Address_Address1']")).sendKeys("23 Bayview street");
        System.out.println("Address 1 is been entered");

        driver.findElement(By.xpath("//input[@id='Address_Address2']")).sendKeys("Near Yorkdale mall");
        System.out.println("Address 2 is been entered");

        driver.findElement(By.xpath("//input[@id='Address_ZipPostalCode']")).sendKeys("L7U065");
        System.out.println("Postal code is been entered");

        driver.findElement(By.id("Address_PhoneNumber")).sendKeys("6470971256");
        System.out.println("Phone number is been entered");

        driver.findElement(By.name("Address.FaxNumber")).sendKeys("5671234908");
        System.out.println("Fax number is been entered");

        driver.findElement(By.xpath("//input[@class='button-1 save-address-button']")).click();
        System.out.println("Save button is been clicked");


    }
}
