package teachings.selenium.webElementBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class OrangeHRM_OnboardingTestCase {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.get("https://automatetest-trials710.orangehrmlive.com/");
        System.out.println("OrangeHRM Application is loaded");

        String title = driver.getTitle();
        System.out.println("Title of the page is :"+title);

        driver.findElement(By.name("txtUsername")).sendKeys("Admin");
        System.out.println("UserName is entered");

        driver.findElement(By.id("txtPassword")).sendKeys("Admin@123");
        System.out.println("Password is entered");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Login button is clicked");

        String s1 = driver.getTitle();
        String s2 = "Employee Management";
        if(s1.equalsIgnoreCase(s2)){
            System.out.println("Title is Matched and Login is successful");
        }else{
            System.out.println("Title is not Matched and Login is not successful");
        }

        Thread.sleep(8000);

        driver.findElement(By.xpath("(//a[@data-automation-id='menu_onboarding_Onboarding'])[1]/span")).click();
        System.out.println("Onboarding Link is clicked");

        Thread.sleep(12000);
        driver.findElement(By.xpath("//i[text()='add']")).click();
        System.out.println("Add button is clicked");
        Thread.sleep(12000);
        driver.findElement(By.cssSelector("#OhrmJob_name")).sendKeys("AutomationCatalogue");
        System.out.println("Name is entered");

        driver.findElement(By.xpath("//form[@name='frmOhrmJob']/div[1]/div[1]/div[2]/div[1]/input")).click();
        System.out.println("Location drop-down is clicked");

        List<WebElement> elements_Locations = driver.findElements(By.xpath("//form[@name='frmOhrmJob']/div[1]/div[1]/div[2]/div[1]/ul/li/span"));
        for(WebElement element:elements_Locations){
            String location = element.getText();
            if(location.equalsIgnoreCase("Mexico Office")){
                element.click();
                System.out.println("Location drop-down is clicked");
                break;
            }
        }

        String date = "21-December-2032";
        String day = date.split("-")[0];
        String month = date.split("-")[1];
        String year = date.split("-")[2];


        driver.findElement(By.xpath("//div[@class='select-wrapper picker__select--year']/input")).click();
        System.out.println("Year drop-down is clicked");

        List<WebElement> elements_years = driver.findElements(By.xpath("//div[@class='select-wrapper picker__select--year']/ul/li/span"));
        for(WebElement element:elements_years){
            String actualYear = element.getText();
            if(actualYear.equalsIgnoreCase(year)){
                element.click();
                System.out.println("Year is Selected");
                break;
            }
        }


    }
}
