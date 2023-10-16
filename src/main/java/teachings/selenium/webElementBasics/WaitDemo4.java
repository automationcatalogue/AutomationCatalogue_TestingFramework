package teachings.selenium.webElementBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitDemo4 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome browser is launched");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.manage().window().maximize();
        System.out.println("Chrome browser is maximized");

        driver.get("https://automatetest-trials710.orangehrmlive.com/");
        System.out.println("Orange HRM Application is loaded");

        driver.findElement(By.name("txtUsername")).sendKeys("Admin");
        System.out.println("Username is Entered");

        driver.findElement(By.id("txtPassword")).sendKeys("Admin@123");
        System.out.println("Password is Entered");

        driver.findElement(By.xpath("//*[@id='frmLogin']/div[4]/button")).submit();
        System.out.println("Login button is clicked");

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='frmLogin']/div[4]/button")));
        System.out.println("Element is Invisible");

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='job-title']"),"CHRO"));
        System.out.println("CHRO Job title is displayed");

        wait.until(ExpectedConditions.titleContains("Employee Management"));
        wait.until(ExpectedConditions.urlContains("/client/#/dashboard"));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//a[@data-automation-id='menu_pim_viewEmployeeList'])[3]")));
        System.out.println("EmployeeManagement link is invisible");
    }
}
