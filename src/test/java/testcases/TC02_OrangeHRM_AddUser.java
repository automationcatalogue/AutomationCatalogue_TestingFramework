package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TC02_OrangeHRM_AddUser {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        driver.manage().window().maximize();
        System.out.println("The chrome window is been maximized");

        driver.get("https://automatetest-trials710.orangehrmlive.com/");
        System.out.println("Orange HRM Application is been loaded");

        driver.findElement(By.name("txtUsername")).sendKeys("Admin");
        System.out.println("User name is been entered");

        driver.findElement(By.id("txtPassword")).sendKeys("Admin@123");
        System.out.println("Password is been entered");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Login button is been clicked");

        driver.findElement(By.xpath("(//a[@data-automation-id='menu_admin_viewSystemUsers'])[1]/span")).click();
        System.out.println("HR administration is been clicked");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='systemUserDiv']/crud-panel/div/div/list/table/tbody/tr[1]/td[2]/ng-include/span")));

        driver.findElement(By.xpath("//i[text()='add']")).click();
        System.out.println("Add button is been clicked");

        driver.findElement(By.id("selectedEmployee_value")).sendKeys("Charlie Carter");
        System.out.println("Employee name is been entered");

        Thread.sleep(1000);
        driver.findElement(By.id("selectedEmployee_value")).sendKeys(Keys.TAB);
        System.out.println("Tab button is pressed");

        driver.findElement(By.id("user_name")).sendKeys("Test_Asma12312");
        System.out.println("User name is been entered");


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='modal-save-button']")));

        //ESS role dropdown
        //driver.findElement(By.xpath("((//button[@type='button'])[2]")).click();
        driver.findElement(By.cssSelector("button.btn[aria-owns=\"bs-select-1\"]")).click();
        System.out.println("Ess drop down is been selected");
        //driver.findElement(By.id("bs-select-10-1")).click();
        driver.findElement(By.cssSelector("#bs-select-1-1")).click();
        System.out.println("Default ESS is been selected");

        //supervisor role dropdown with Test HR selected
        driver.findElement(By.xpath("//button[@type='button'][@data-id='supervisorrole']")).click();
        System.out.println("Supervisor role dropdown is been selected");
        driver.findElement(By.xpath("//a[@id='bs-select-2-2']")).click();
        System.out.println("Test HR is been selected");

        //Admin role drop down
        driver.findElement(By.xpath("//button[@data-id='adminrole']/div/div/div")).click();
        System.out.println("Admin Role drop-down is clicked");
        Thread.sleep(2000);
        List<WebElement> AdminRole=driver.findElements(By.xpath("//button[@data-id='adminrole']//following-sibling::div//ul/li//span"));
        for (WebElement element: AdminRole){
            String actualValue = element.getText();
            if (actualValue.equalsIgnoreCase("Recruitment Manager")) {
                element.click();
                break;
            }
        }
        System.out.println("Admin role drop down is been selected");

        //Password and confirm password
        driver.findElement(By.id("password")).sendKeys("Automationtest123@");
        System.out.println("Password is been entered");
        driver.findElement(By.cssSelector("#confirmpassword")).sendKeys("Automationtest123@");
        System.out.println("Password is been confirmed");

        Thread.sleep(4000);
        //save button is been clicked
        driver.findElement(By.xpath("//button[@id='modal-save-button']")).click();
        System.out.println("Save button is been clicked");
        Thread.sleep(3000);
        //save button is clicked again
        driver.findElement(By.xpath("//button[@id='modal-save-button']")).click();
        System.out.println("Save button is been clicked at the end");


    }
}
