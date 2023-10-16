package teachings.selenium.webElementBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginDemo {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        System.out.println("Edge Browser is launched");

        driver.get("https://seleniumautom-trials710.orangehrmlive.com/");
        System.out.println("OrangeHRM URL is loaded");

        driver.manage().window().maximize();
        System.out.println("Chrome Browser is maximized");

        driver.findElement(By.name("txtUsername")).sendKeys("Admin");
        System.out.println("Username is entered");

        driver.findElement(By.id("txtPassword")).sendKeys("Admin@123");
        System.out.println("Password is entered");

        driver.findElement(By.xpath("//*[@id='frmLogin']/div[4]/button")).click();
        System.out.println("Login button is clicked");

    }
}
