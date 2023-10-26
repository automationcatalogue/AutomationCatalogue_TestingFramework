package testcases.orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class TC07_OrangeHRM_Nationality {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://automatetest-trials710.orangehrmlive.com/auth/login");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@name='txtUsername']")).sendKeys("Admin");
        System.out.println("Username entered");
        driver.findElement(By.xpath("//*[@name='txtPassword']")).sendKeys("Admin@123");
        System.out.println("Password entered");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        System.out.println("login button clicked");

        driver.findElement(By.xpath("//a[@data-automation-id='menu_pim_viewEmployeeList']/span")).click();
        System.out.println("HR Management is selected");
        driver.findElement(By.xpath("//i[@class='expand-icon material-icons']")).click();
        System.out.println("More is selected");

        driver.findElement(By.xpath("//a[@data-automation-id='more_menu_child_menu_admin_nationality']")).click();
        System.out.println("Nationality is selected");

        driver.findElement(By.xpath("//i[text()='add']")).click();
        System.out.println("Add button is selected");

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("o");
        System.out.println("Anupreddy is enetered as nationality");
        driver.findElement(By.xpath("//a[@class='modal-action waves-effect waves-green btn primary-btn']")).click();
        System.out.println("Save button is clicked");

        driver.findElement(By.xpath("//a[@data-automation-id='menu_pim_viewEmployeeList']/span")).click();
        System.out.println("HR Management is selected");
        driver.findElement(By.xpath("//a[@data-automation-id='menu_pim_viewMyDetails']")).click();
        System.out.println("Myinfo is clicked");
        driver.findElement(By.xpath("//a[@data-automation-id='menu_employee_profile_PersonalDetails']")).click();
        System.out.println("Personal Details is clicked");
        driver.findElement(By.xpath("((//input[@readonly='true'])[4]")).click();
        System.out.println("Nationality Dropdown is clicked");

        List<WebElement> allElements = driver.findElements(By.xpath("(//ul[@class='dropdown-content select-dropdown '])[4]/li"));
        for (WebElement element:allElements){
            String Actualvalue = element.getText();
            if(Actualvalue.equalsIgnoreCase("o")) {
                element.click();
                break;
            }
        }

        System.out.println("Nationality is Selected");


    }
}
